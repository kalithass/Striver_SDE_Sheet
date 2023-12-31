package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LCAOfTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode res = lowestCommonAncestor(root, root.left.right, root.right.right);
        System.out.println(res);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursiveHelper(root, p, q);
    }

    private TreeNode recursiveHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root==p || root==q) return root;
        TreeNode left = recursiveHelper(root.left, p, q);
        TreeNode right = recursiveHelper(root.right, p, q);
        if (left != null && right!= null) return root;
        if (left != null ) return left;
        return right;
    }
}
