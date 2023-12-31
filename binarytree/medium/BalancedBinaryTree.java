package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean res = isBalanced(root);
        System.out.println(res);
    }

    public boolean isBalanced(TreeNode root) {
//        return naiveApproach(root);
        return optimalApproach(root) != -1;
    }

    private int optimalApproach(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftHeight = optimalApproach(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = optimalApproach(root.right);
        if (rightHeight == -1) return -1;

        if(Math.abs(rightHeight - leftHeight) >= 2) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean naiveApproach(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left-right) <=1 && naiveApproach(root.left) && naiveApproach(root.right);
    }

    public int height(TreeNode root)
    {
        if(root == null) {
            return 0;
        }
        int leftHeight = 1 + height(root.left);
        int rightHeight = 1 + height(root.right);
        return Math.max(leftHeight, rightHeight);
    }
}
