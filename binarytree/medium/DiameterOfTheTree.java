package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfTheTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        int res = diameterOfBinaryTree(root);
        System.out.println(res);
    }


    // diameter max distance between any two nodes
    // intuition : from current node (A), left depth is 5 and right depth is 3
    // diameter will be 8 (5+3), since they are the further away A as the center
    // hence find the max diameter for each node and find the max one
    public int diameterOfBinaryTree(TreeNode root) {
        int[] a = new int[1];
        recursiveHelper(root, a);
        return a[0];
    }

    private int recursiveHelper(TreeNode root, int[] a) {
        if (root == null) return 0 ;
        int left = recursiveHelper(root.left, a);
        int right = recursiveHelper(root.right, a);
        a[0] = Math.max(a[0], left+right);
        return 1 + Math.max(left, right);
    }
}
