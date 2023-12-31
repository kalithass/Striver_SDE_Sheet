package strivers.binarytree.traversals;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
//        return iterativeApproach(root);
//        return recursiveApproach(root);
        return morrisTraversal(root);
    }

    private List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) temp = temp.right;
                if (temp.right != null) {
                    res.add(curr.val);
                    curr = curr.right;
                    temp.right = null;
                } else {
                    temp.right = curr;
                    curr = curr.left;
                }
            }
        }
        return res;
    }

    private List<Integer> iterativeApproach(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    private List<Integer> recursiveApproach(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursiveHelper(root, res);
        return res;
    }

    private void recursiveHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        recursiveHelper(root.left, res);
        res.add(root.val);
        recursiveHelper(root.right, res);
    }
}
