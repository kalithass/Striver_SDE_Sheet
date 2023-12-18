package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.Node;
import strivers.BinarySearchTrees.TreeNode;

//https://www.codingninjas.com/studio/problems/ceil-from-bst_920464
public class CeilInBinaryTree implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int res = findCeil(root, 2);
        System.out.println(res);
    }

    public  static int findCeil(TreeNode node, int x) {
        int res = -1;
        while (node != null) {
            if(node.val == x) return x;
            if(node.val > x) {
                res = node.val;
                node = node.left;
            }
            else node = node.right;
        }
        return res;
    }

    public static int floorInBST(TreeNode root, int X) {
        int res = -1;
        while(root != null) {
            if(root.val == X) return X;
            if(root.val > X) {
                root = root.left;
            } else {
                res = root.val;
                root = root.right;
            }
        }
        return res;
    }
}
