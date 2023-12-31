package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructTreeFromInOrderAndPreOrder implements App {
    @Override
    public void run() {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        printInorder(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> positionMap = getPositionMap(inorder);
        return recursiveHelper(preorder, 0, inorder.length-1, 0, preorder.length - 1, positionMap);
    }

    TreeNode recursiveHelper(int[] preorder, int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> positionMap)
    {
        if (preStart > preEnd || inStart >inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = positionMap.get(preorder[preStart]);
        int leftLength = rootIndex - inStart;

        root.left = recursiveHelper(preorder, inStart, rootIndex-1, preStart+1, preStart+leftLength, positionMap);
        root.right = recursiveHelper(preorder, rootIndex+1, inEnd, preStart+leftLength+1, preEnd,positionMap );

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
