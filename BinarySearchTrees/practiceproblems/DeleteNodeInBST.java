package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

//https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeInBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode res = deleteNode(root, 7);
        System.out.println(res);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
//        return iterativeApproach(root, key);
        return recursiveApproach(root, key);
    }

    private TreeNode recursiveApproach(TreeNode root, int key) {
        if(root==null) return root;
        if(key < root.val)
            root.left = recursiveApproach(root.left, key);
        else if(key > root.val)
            root.right = recursiveApproach(root.right, key);
        else{
            return helper(root);
        }
        return root;
    }

    private TreeNode iterativeApproach(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);
        TreeNode temp = root;
        while (temp != null) {
            if(temp.val > key) {
                if(temp.left != null && temp.left.val == key) {
                    temp.left = helper(temp.left);
                    break;
                } else  {
                    temp = temp.left;
                }
            }  else {
                if (temp.right != null && temp.right.val == key) {
                    temp.right = helper(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }

    private TreeNode helper(TreeNode root) {
        // TreeNode right = root.right;
        // TreeNode left = root.left;
        // if(right == null) return left;
        // if(left == null) return right;

        // TreeNode temp = right;
        // while (temp.left != null) {
        //     temp = temp.left;
        // }
        // temp.left = left;
        // return right;

        TreeNode right = root.right;
        TreeNode left = root.left;
        if(right == null) return left;
        if(left == null) return right;

        TreeNode temp = left;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        return left;
    }
}
