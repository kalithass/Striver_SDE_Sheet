package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/predecessor-and-successor-in-bst_893049
public class SuccessorPredecessorInBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);
        List<Integer> res = predecessorSuccessor(root, 10);
        System.out.println(res);
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        int predecessor = findPredecessor(root, key);
        int successor = findSuccessor(root, key);
        List<Integer> res = new ArrayList<>();
        res.add(predecessor);
        res.add(successor);
        return res;
    }

    private static int findSuccessor(TreeNode root, int key) {
        int res = -1;
        while (root != null) {
            if(root.val > key) {
                res = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    private static int findPredecessor(TreeNode root, int key) {
        int res = -1;
        while (root != null) {
            if(root.val > key) {
                root = root.left;
            } else {
                res = root.val;
                root = root.right;
            }
        }
        return res;
    }


}
