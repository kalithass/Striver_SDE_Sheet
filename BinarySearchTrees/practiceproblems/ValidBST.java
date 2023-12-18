package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        boolean res = isValidBST(root);
        System.out.println(res);
    }


    public boolean isValidBST(TreeNode root) {
        return recursiveHelper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursiveHelper(TreeNode root, long min, long max) {
        if(root  == null) return true;
        if(root.val <= min || root.val>=max) return false;
        return recursiveHelper(root.left,min,root.val) && recursiveHelper(root.right, root.val, max);
    }
}
