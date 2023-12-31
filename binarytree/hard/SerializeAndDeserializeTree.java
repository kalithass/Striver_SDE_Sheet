package strivers.binarytree.hard;

import com.sun.source.tree.Tree;
import strivers.App;
import strivers.binarytree.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeAndDeserializeTree implements App {


    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
//        root.left.right.left = new TreeNode(10);
//        root.left.right.right = new TreeNode(11);
//        root.right.left.left = new TreeNode(12);
//        root.right.left.right = new TreeNode(13);
//        root.right.right.left = new TreeNode(14);
//        root.right.right.right = new TreeNode(15);
        String serializedTree = serialize(root);
//        root = deserialize(serializedTree);
        System.out.println(serializedTree);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();

        if (root == null) return res.toString();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i =0;i<size;i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    res.append("# ");
                    continue;
                }
                res.append(temp.val).append(" ");
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i=1;i<arr.length;i++) {
            TreeNode parent = queue.poll();
            if(!arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!arr[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
