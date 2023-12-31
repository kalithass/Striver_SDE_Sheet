package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructTreeFomInOrderAndPostOrder implements App {
    @Override
    public void run() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        printInorder(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> positionMap = getPositionMap(inorder);
        return recursiveHelper(postorder, 0, inorder.length - 1, 0, postorder.length - 1, positionMap);
    }

    private TreeNode recursiveHelper(int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> positionMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = positionMap.get(postorder[postEnd]);
        int length = rootIndex - inStart;

//        root.left = recursiveHelper(postorder, inStart, rootIndex - 1, postStart, postStart + length - 1, positionMap);
//        root.right = recursiveHelper(postorder, rootIndex + 1, inEnd, postStart + length, postEnd - 1, positionMap);

        root.left = recursiveHelper(postorder, inStart, rootIndex - 1, postStart, postStart + length - 1, positionMap);
        root.right = recursiveHelper(postorder, rootIndex + 1, inEnd, postStart + length, postEnd - 1, positionMap);

        return root;
    }

    private void printInorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printInorder(root.left);
        printInorder(root.right);
    }

    private Map<Integer, Integer> getPositionMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

}
