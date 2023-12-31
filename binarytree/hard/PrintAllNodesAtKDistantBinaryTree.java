package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class PrintAllNodesAtKDistantBinaryTree implements App {

    @Override
    public void run() {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        List<Integer> res = distanceK(root, root.right.left, 3);
        System.out.println(res);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        constructParentNetwork(root, map);
        List<Integer> res =  new ArrayList<>();
//        map.forEach((x,y) -> System.out.println(x+" "+y.val));
        addAllNodesAtDistantK(target, k, 0, res, map, visited);
        return res;
    }

    private void addAllNodesAtDistantK(TreeNode node, int k, int distance,
                                       List<Integer> res, Map<TreeNode, TreeNode> map, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) return;

//        System.out.println(node+" "+distance+" "+map.get(node));
        visited.add(node);
        if (distance == k) {
            res.add(node.val);
            return;
        }

        if (node.left != null ) addAllNodesAtDistantK(node.left, k, distance+1, res, map, visited);
        if (node.right != null ) addAllNodesAtDistantK(node.right, k, distance+1, res, map, visited);
        if (map.containsKey(node)) addAllNodesAtDistantK(map.get(node), k, distance+1, res, map, visited);
    }

    private void constructParentNetwork(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        if (root.right != null) map.put(root.right, root);
        if (root.left != null) map.put(root.left, root);
        constructParentNetwork(root.right, map);
        constructParentNetwork(root.left, map);
    }
}
