package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        int res = maxPathSum(root);
        System.out.println(res);
    }

    public int maxPathSum(TreeNode root) {
        int[] a = new int[1];
        a[0] =Integer.MIN_VALUE;
        recursiveHelper(root, a);
        return a[0];
    }

    private int recursiveHelper(TreeNode root, int[] a) {
        if (root == null) return 0;

        // using kadens algorithm technique
        int left = Math.max(0, recursiveHelper(root.left, a));
        int right = Math.max(0, recursiveHelper(root.right, a));
        a[0] = Math.max(a[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
