package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class ConstructBstFromPreorderTraversal implements App {

    @Override
    public void run() {
        TreeNode res = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(res.val);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
//        return naiveApproach(preorder);
        return recursiveApproach(preorder);
    }

    private TreeNode recursiveApproach(int[] preorder) {
        return recursiveHelper(preorder, Integer.MAX_VALUE,new int[]{0});
    }

    private TreeNode recursiveHelper(int[] preorder, int maxValue, int[] ind) {
        if (ind[0]==preorder.length || preorder[ind[0]] > maxValue) return null;
        TreeNode node = new TreeNode(preorder[ind[0]++]);
        node.left = recursiveHelper(preorder, node.val, ind);
        node.right = recursiveHelper(preorder, maxValue, ind);
        return node;
    }

    private TreeNode naiveApproach(int[] preorder) {
        TreeNode root = null;
        for(int element : preorder) {
            root = insertIntoBST(root, element);
        }
        return root;
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
