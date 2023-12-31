package strivers.binarytree.hard;

import strivers.App;
import strivers.Main;
import strivers.binarytree.leetcode.TreeNode;

//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class NumberOfNodesInCompleteBinaryTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        int res = countNodes(root);
        System.out.println(res);
    }

    // we can do regular O(N) traversal
    // but since it is complete binary tree from particular node
    // left height and right height is same it will have 2^height-1 nodes
    public int countNodes(TreeNode root) {
        return recursiveHelper(root);
    }

    private int recursiveHelper(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) return (int) Math.pow(2, leftHeight) -1;
        return 1 + recursiveHelper(root.left) + recursiveHelper(root.right);
    }

    private int getRightHeight(TreeNode root) {
        int h = 0;
        while (root!=null) {
            root = root.right;
            h++;
        }
        return h;
    }

    private int getLeftHeight(TreeNode root) {
        int h = 0;
        while (root!=null) {
            root = root.left;
            h++;
        }
        return h;
    }
}
