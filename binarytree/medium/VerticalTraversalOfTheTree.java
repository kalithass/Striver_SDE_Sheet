package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalTraversalOfTheTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = verticalTraversal(root);
        System.out.println(res);
    }


    // time complexity logN * (logN * NlogN)
    // outer map * (inner map * (array sorting))
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return recursiveApproach(root);
//        return iterativeApproach(root);
    }

    private List<List<Integer>> recursiveApproach(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        recursiveHelper(root, map, 0, 0);
        return extractOutput(map);
    }

    private void recursiveHelper(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map, int xAxis, int level) {
        if (root == null) return;
        if (!map.containsKey(xAxis)) map.put(xAxis, new TreeMap<>());
        if (!map.get(xAxis).containsKey(level)) map.get(xAxis).put(level, new ArrayList<>());
        map.get(xAxis).get(level).add(root.val);
        recursiveHelper(root.left, map, xAxis - 1, level + 1);
        recursiveHelper(root.right, map, xAxis + 1, level + 1);
    }

    private static List<List<Integer>> iterativeApproach(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Holder> queue = new LinkedList<>();


        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        if (root == null) return res;


        queue.add(new Holder(0, 0, root));

        while (!queue.isEmpty()) {

            Holder temp = queue.poll();
            if (!map.containsKey(temp.xAxis)) map.put(temp.xAxis, new TreeMap<>());
            if (!map.get(temp.xAxis).containsKey(temp.level)) map.get(temp.xAxis).put(temp.level, new ArrayList<>());

            map.get(temp.xAxis).get(temp.level).add(temp.node.val);

            if (temp.node.left != null) queue.add(new Holder(temp.level + 1, temp.xAxis - 1, temp.node.left));
            if (temp.node.right != null) queue.add(new Holder(temp.level + 1, temp.xAxis + 1, temp.node.right));
        }
        return extractOutput(map);
    }

    private static List<List<Integer>> extractOutput(Map<Integer, Map<Integer, List<Integer>>> map) {
        List<List<Integer>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            List<Integer> list = new ArrayList<>();
            v.forEach((k2, v2) -> {
                Collections.sort(v2);
                list.addAll(v2);
            });
            res.add(list);
        });
        return res;
    }

    static class Holder {
        int level;
        int xAxis;

        TreeNode node;

        public Holder(int level, int xAxis, TreeNode node) {
            this.level = level;
            this.xAxis = xAxis;
            this.node = node;
        }
    }
}