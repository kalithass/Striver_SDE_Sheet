package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.codingNinja.BinaryTreeNode;

import java.util.*;

//https://www.codingninjas.com/studio/problems/time-to-burn-tree_1469067
public class MinTimeToBurnTree implements App {
    @Override
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);
        int res = timeToBurnTree(root, 2);
        System.out.println(res);
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        return iterativeBurn(root, start);
//        return recursiveApproach(root, start);
    }

    private static int iterativeBurn(BinaryTreeNode<Integer> root, int start) {
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map = new HashMap<>();
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
        constructParentNetwork(root, map);
        BinaryTreeNode<Integer> startNode = getStartNode(root, start);
        int res = 0;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    burned = true;
                    visited.add(node.left);
                    queue.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    burned = true;
                    visited.add(node.right);
                    queue.add(node.right);
                }

                if (map.get(node) != null && !visited.contains(map.get(node))) {
                    burned = true;
                    visited.add(map.get(node));
                    queue.add(map.get(node));
                }
            }
            if (burned) res++;
        }
        return res;
    }

    private static int recursiveApproach(BinaryTreeNode<Integer> root, int start) {
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map = new HashMap<>();
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
        constructParentNetwork(root, map);
        BinaryTreeNode<Integer> startNode = getStartNode(root, start);
        int[] res = new int[1];
        recursiveBurn(startNode, map, visited, 0, res);
        return res[0] - 1;
    }

    private static void recursiveBurn(BinaryTreeNode<Integer> node, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map, Set<BinaryTreeNode<Integer>> visited, int distance, int[] res) {
        if (visited.contains(node)) return;
        if (node == null) {
            res[0] = Math.max(res[0], distance);
            return;
        }
        visited.add(node);
        recursiveBurn(node.left, map, visited, distance + 1, res);
        recursiveBurn(node.right, map, visited, distance + 1, res);
        if (map.containsKey(node)) recursiveBurn(map.get(node), map, visited, distance + 1, res);
    }

    private static BinaryTreeNode<Integer> getStartNode(BinaryTreeNode<Integer> root, int start) {
        if (root == null) return null;
        // System.out.println(root.data);
        if (root.data == start) return root;
        BinaryTreeNode<Integer> left = getStartNode(root.left, start);
        if (left != null) return left;
        return getStartNode(root.right, start);
    }

    private static void constructParentNetwork(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map) {
        if (root == null) return;
        if (root.right != null) map.put(root.right, root);
        if (root.left != null) map.put(root.left, root);
        constructParentNetwork(root.right, map);
        constructParentNetwork(root.left, map);
    }
}
