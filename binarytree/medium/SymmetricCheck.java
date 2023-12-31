package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricCheck implements App {

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
        boolean res = isSymmetric(root);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right == null) return true;
        if(left==null || right == null) return false;
        if(left.val == right.val) return helper(left.left, right.right) && helper(left.right, right.left);
        return false;
    }
}
