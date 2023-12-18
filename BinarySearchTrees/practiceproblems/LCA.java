package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCA implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode res = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(res.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        return lcaForBT(root, p, q);
        return lcaForBST(root, p, q);
    }

    private TreeNode lcaForBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val > root.val && q.val>root.val) return lcaForBST(root.right, p, q);
        if(p.val < root.val && q.val<root.val) return lcaForBST(root.left, p, q);
        return root;
    }

    private TreeNode lcaForBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null || root == p || root == q) return root;
        TreeNode leftVal = lowestCommonAncestor(root.left, p, q);
        TreeNode rightVal = lowestCommonAncestor(root.right, p, q);
        if(leftVal==null) return rightVal;
        if(rightVal == null) return leftVal;
        return root;
    }
}
