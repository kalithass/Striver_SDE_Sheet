package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/recover-binary-search-tree/
public class ReverseBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(root + " " + root.left + " " + root.left.right);
        recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] arr = new TreeNode[2];
        inOrder(root, arr, new TreeNode[]{new TreeNode(Integer.MIN_VALUE)});
        int temp = arr[0].val;
        arr[0].val = arr[1].val;
        arr[1].val = temp;
    }

    private void inOrder(TreeNode root, TreeNode[] arr, TreeNode[] prev) {
        if (root == null) return;
        inOrder(root.left, arr, prev);

        if (root.val < prev[0].val) {
            if (arr[0] == null) {
                arr[0] = prev[0];
                arr[1] = root;
            } else {
                arr[1] = root;
            }
        }

        prev[0] = root;
        inOrder(root.right, arr, prev);
    }
}
