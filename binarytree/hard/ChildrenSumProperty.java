package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.codingNinja.BinaryTreeNode;

//https://www.codingninjas.com/studio/problems/childrensumproperty_790723
public class ChildrenSumProperty implements App {
    @Override
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        changeTree(root);
    }

    // go down and increase the value
    public static void changeTree(BinaryTreeNode<Integer> root) {
        //    recursiveOptimalHelper(root);
        recursiveNaiveHelper(root);
    }

    private static void recursiveNaiveHelper(BinaryTreeNode<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) return;
        recursiveNaiveHelper(root.left);
        recursiveNaiveHelper(root.right);
        int sum = (root.left == null ? 0 : root.left.data) + (root.right == null ? 0 : root.right.data);
        int diff = sum - root.data;
        if (diff >= 0) root.data = sum;
        else increment(root, -diff);
    }

    static void increment(BinaryTreeNode<Integer> root, int diff) {
        if (root.left != null) {
            root.left.data += diff;
            increment(root.left, diff);
        }

        else if (root.right != null) {
            root.right.data += diff;
            increment(root.right, diff);
        }
    }

    private static void recursiveOptimalHelper(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        // update child if root is greater than child sum
        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;
        if (root.data > sum) {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        recursiveOptimalHelper(root.left);
        recursiveOptimalHelper(root.right);

        sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;
        root.data = sum;

    }
}

