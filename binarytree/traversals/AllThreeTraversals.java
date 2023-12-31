package strivers.binarytree.traversals;

import strivers.App;
import strivers.binarytree.codingNinja.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.codingninjas.com/studio/problems/tree-traversals_981269
public class AllThreeTraversals  implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        List<List<Integer>> res = getTreeTraversal(root);
        System.out.println(res);
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        return recursiveApproach(root);
//        return iterativeApproach(root);
    }

    private static List<List<Integer>> recursiveApproach(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        recursiveHelper(inOrder, preOrder, postOrder, root);
        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);
        return res;
    }

    private static void recursiveHelper(List<Integer> inOrder, List<Integer> preOrder, List<Integer> postOrder, TreeNode root) {
        if (root == null) return;
        preOrder.add(root.data);
        recursiveHelper(inOrder, preOrder, postOrder, root.left);
        inOrder.add(root.data);
        recursiveHelper(inOrder, preOrder, postOrder, root.right);
        postOrder.add(root.data);
    }

    private static List<List<Integer>> iterativeApproach(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        if (root == null) return res;

        stack.add(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair temp = stack.pop();
            int num = temp.num;
            TreeNode node = temp.node;
            if (num == 1) {
                preOrder.add(node.data);
                stack.add(new Pair(node, 2));
                if (node.left != null) stack.add(new Pair(node.left, 1));
            } else if(num == 2) {
                inOrder.add(node.data);
                stack.add(new Pair(node, 3));
                if (node.right != null) stack.add(new Pair(node.right, 1));
            } else {
                postOrder.add(node.data);
            }
        }
        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);
        return res;
    }

    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
