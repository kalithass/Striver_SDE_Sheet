package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/same-tree/
public class CheckIfTwoTreesAreIdentical implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        boolean res = isSameTree(root, root);
        System.out.println(res);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q==null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left ) && isSameTree(p.right, q.right);
    }
}
