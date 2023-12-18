package strivers.BinarySearchTrees;

import strivers.App;

import javax.swing.plaf.PanelUI;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class SumInBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        boolean res = findTarget(root, 90);
        System.out.println(res);
    }

    public boolean findTarget(TreeNode root, int k) {
//        return naiveApproach(root, k);
        return optimalApproach(root, k);
    }

    private boolean optimalApproach(TreeNode root, int k) {
        DoubleEdgedIterator ascItr = new DoubleEdgedIterator(false, root);
        DoubleEdgedIterator descItr = new DoubleEdgedIterator(true, root);

        int left = ascItr.next();
        int right = descItr.next();
        while (left < right) {
            int sum = left+right;
            if(sum == k ) return true;
            if(sum > k) right = descItr.next();
            else left = ascItr.next();
        }
        return false;
    }

    private boolean naiveApproach(TreeNode root, int k) {
        return recursionHelper(root, k, new HashSet<>());
    }

    private boolean recursionHelper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) return false;
        boolean res = recursionHelper(root.left, k, set);
        if (res) return true;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return recursionHelper(root.right, k, set);
    }
}

class DoubleEdgedIterator {
    private Deque<TreeNode> stack = new LinkedList<>();
    private boolean reversal;

    DoubleEdgedIterator(boolean reversal, TreeNode root) {
        this.reversal = reversal;
        pushNodes(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode top = stack.pop();
        if(reversal) pushNodes(top.left);
        else pushNodes(top.right);
        return top.val;
    }

    private void pushNodes(TreeNode root) {
        while (root!=null) {
            stack.push(root);
            if(reversal) root = root.right;
            else root = root.left;
        }
    }
}