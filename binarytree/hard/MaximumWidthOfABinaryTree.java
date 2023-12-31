package strivers.binarytree.hard;

import com.sun.source.tree.Tree;
import strivers.App;
import strivers.Main;
import strivers.binarytree.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class MaximumWidthOfABinaryTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        int res = widthOfBinaryTree(root);
        System.out.println(res);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        long res = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            long min = 0, max = 0;
            for (int i=0;i<size;i++) {
                Pair pair = queue.poll();
                if(i == 0) min = pair.index;
                if (i == size - 1) max = pair.index;
                if (pair.node.left!=null) queue.add(new Pair(pair.node.left, 2* pair.index+1));
                if (pair.node.right!=null) queue.add(new Pair(pair.node.right, 2* pair.index+2));
            }
//            System.out.println(max+" "+min);
            res = Math.max(res, max - min +1);
        }
        return (int) res;
    }

    static class Pair {
        TreeNode node;
        long index;

        public Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
}
