package strivers.binarytree.hard;

import strivers.App;
import strivers.binarytree.codingNinja.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599
public class RootToPath implements App {
    @Override
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        List<String> res = allRootToLeaf(root);
        System.out.println(res);
    }

    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        recursiveHelper(root, res, sb);
        return res;
    }

    private static void recursiveHelper(BinaryTreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) return;
        int len = sb.length();
        if(root.left == null && root.right== null) res.add(sb.append(root.data).toString());
        else sb.append(root.data).append(" ");
        recursiveHelper(root.left, res, sb);
        recursiveHelper(root.right, res, sb);
        sb.setLength(len);
    }
}
