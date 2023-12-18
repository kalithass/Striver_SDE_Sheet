package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertNodeInBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode res = insertIntoBST(root, 5);
        System.out.println(res);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode  = new TreeNode(val);
        if(root == null) return newNode;
        TreeNode last = null;
        TreeNode temp = root;
        while (temp != null) {
            last = temp;
            if(temp.val < val) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        if(last.val > val) last.left = newNode;
        else last.right = newNode;
        return root;
    }
}
