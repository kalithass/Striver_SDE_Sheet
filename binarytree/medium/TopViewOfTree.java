package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.codingNinja.TreeNode;

import java.util.*;

//https://www.codingninjas.com/studio/problems/top-view-of-binary-tree_799401
public class TopViewOfTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);
        List<Integer> res = getTopView(root);
        System.out.println(res);
    }

    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map= new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                Pair temp = queue.poll();
                if (!map.containsKey(temp.xAxis)) map.put(temp.xAxis, temp.node.data);
                if (temp.node.left != null) queue.add(new Pair(temp.node.left, temp.xAxis-1));
                if (temp.node.right != null) queue.add(new Pair(temp.node.right, temp.xAxis+1));
            }
        }

        // map is sorted by key -> xAxis
        res.addAll(map.values());
        return res;
    }

    static class Pair {
        TreeNode node;
        int xAxis;

        public Pair(TreeNode node, int xAxis) {
            this.node = node;
            this.xAxis = xAxis;
        }
    }

}
