package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.codestudio.TreeNode;

//https://www.codingninjas.com/studio/problems/size-of-largest-bst-in-binary-tree_893103
public class LargestBST implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int res = largestBST(root);
        System.out.println(res);
    }

    public static int largestBST(TreeNode root) {
        Container res = postOrderOnBST(root);
        return res.size;
    }

    private static Container postOrderOnBST(TreeNode root) {
        if(root == null) {
            return new Container(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Container leftRes = postOrderOnBST(root.left);
        Container rightRes = postOrderOnBST(root.right);
        int val = root.data;
        // if current root forms the bst
        if(leftRes.max < val && val < rightRes.min) {
            int size = 1 + leftRes.size + rightRes.size;
            int min = Math.min(leftRes.min, val);
            int max = Math.max(val, rightRes.max);
            return new Container(size, min, max);
        }
        return new Container(Math.max(leftRes.size, rightRes.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

class Container {
    int size;
    int min;
    int max;

    public Container(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}