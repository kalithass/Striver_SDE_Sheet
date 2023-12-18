package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class FindKthSmallest implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int res = kthSmallest(root, 7);
        System.out.println(res);
    }

    public int kthSmallest(TreeNode root, int k) {
        return recursiveHelper(root, new int[]{k});
    }


    private int recursiveHelper(TreeNode root, int[] k) {
        if(root == null) return -1;
        int res = recursiveHelper(root.left, k);
        if(res!=-1 && k[0]==0) return res;
        k[0]--;
        if(k[0] == 0) return root.val;
        return recursiveHelper(root.right, k);
    }

    private static int recursiveHelperKthLargest(TreeNode root, int[] k) {
        if(root == null) return -1;
        int res = recursiveHelperKthLargest(root.right, k);
        if(res!=-1 && k[0]==0) return res;
        k[0]--;
        if(k[0] == 0) return root.val;
        return recursiveHelperKthLargest(root.left, k);
    }
}
