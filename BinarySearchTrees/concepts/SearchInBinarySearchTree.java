package strivers.BinarySearchTrees.concepts;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBinarySearchTree implements App{

    @Override
    public void run() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode res = searchBST(root, 2);
        System.out.println(res.val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if(root.val == val) return root;
            if(root.val < val) root = root.right;
            else root = root.left;
        }
        return null;
    }
}
