package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.codingNinja.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_790725
public class BoundaryTraversal implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);
        List<Integer> res = traverseBoundary(root);
        System.out.println(res);
    }

    public  static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if(root.left!=null || root.right!=null) res.add(root.data);
        populateLeftBoundary(root, res);
        populateBottom(root, res);
        populateRightBoundary(root, res);
        return res;
    }

    private static void populateRightBoundary(TreeNode root, ArrayList<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        TreeNode node = root.right;
        while (node != null) {
            if (node.right == null && node.left == null) break;
            stack.add(node.data);
            if (node.right != null) node = node.right;
            else node = node.left;
        }

        while (!stack.isEmpty()) res.add(stack.pop());
    }

    // level order traversal
    private static void populateBottom(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.data);
        populateBottom(root.left, res);
        populateBottom(root.right, res);
    }

    private static List<Integer> populateLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode node = root.left;
        while (node!=null) {
            if (node.left == null && node.right == null) break;
            res.add(node.data);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
        return res;
    }
}
