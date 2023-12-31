package strivers.binarytree.traversals;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.*;

//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrderTraversal implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = postorderTraversal(root);
        System.out.println(res);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // return iterativeApproach(root);
        return recursiveApproach(root);
    }

    private List<Integer> iterativeApproach(TreeNode root) {
        return twoStackApproach(root);
    }

    private List<Integer> twoStackApproach(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.addFirst(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        Collections.reverse(res);
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
        recursiveHelper(root.right, res);
        res.add(root.val);
    }
}
