package strivers.binarytree.medium;

import strivers.App;
import strivers.binarytree.codingNinja.TreeNode;

import java.util.*;

//https://www.codingninjas.com/studio/problems/bottom-view-of-binary-tree_893110
public class BottomViewOfBinaryTree implements App {

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
        List<Integer> res = bottomView(root);
        System.out.println(res);
    }

    public static List<Integer> bottomView(TreeNode root) {
        return recursiveApproach(root);
    }

    static List<Integer> recursiveApproach(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                Pair pair = queue.poll();
                map.put(pair.xAxis, pair.node.data);
                if (pair.node.left != null) queue.add(new Pair(pair.node.left, pair.xAxis-1));
                if (pair.node.right != null) queue.add(new Pair(pair.node.right, pair.xAxis+1));
            }
        }
        return new ArrayList<>(map.values());
    }

    static class Pair {
        TreeNode node;
        int xAxis;

        public Pair(TreeNode node, int xAxis) {
            this.node = node;
            this.xAxis = xAxis;
        }
    }
}
