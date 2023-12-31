package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.*;

//https://leetcode.com/problems/binary-tree-right-side-view
public class RightViewOfBinaryTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> res = rightSideView(root);
        System.out.println(res);
    }
    public List<Integer> rightSideView(TreeNode root) {
//        return bruteApproach(root);
        return optimalApproach(root);
    }

    private List<Integer> optimalApproach(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursiveOptimalApproach(root, res, 0);
        return res;
    }

    private void recursiveOptimalApproach(TreeNode root, List<Integer> res,int level) {
        if (root == null) return;
        if (level == res.size()) res.add(root.val);
        recursiveOptimalApproach(root.right, res, level+1);
        recursiveOptimalApproach(root.left, res, level+1);
    }

    private List<Integer>  bruteApproach(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        recursiveNaiveHelper(root, map, 0);
        return new ArrayList<>(map.values());
    }

    private static void recursiveNaiveHelper(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) return;
        if (!map.containsKey(level)) map.put(level, root.val);
        recursiveNaiveHelper(root.right,  map, level+1);
        recursiveNaiveHelper(root.left,  map, level+1);
    }
}
