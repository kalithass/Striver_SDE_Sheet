package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.codestudio.TreeNode;
import strivers.LinkedList.singly.InsertNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/merge-two-bsts_920474
public class Merge2Bst implements App {

    @Override
    public void run() {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(4);

        List<Integer> res = mergeBST(root1, root2);
        System.out.println(res);
    }

    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        Iterator itr1 = new Iterator(root1);
        Iterator itr2 = new Iterator(root2);

        List<Integer> res = new ArrayList<>();
        while (itr2.hasNext() && itr1.hasNext()) {
            if(itr1.current() < itr2.current()) {
                res.add(itr1.current());
                itr1.next();
            } else {
                res.add(itr2.current());
                itr2.next();
            }
        }

        while (itr1.hasNext()) {
            res.add(itr1.current());
            itr1.next();
        }


        while (itr2.hasNext()) {
            res.add(itr2.current());
            itr2.next();
        }

        return res;
    }
}

class Iterator {
    Deque<TreeNode> stack = new LinkedList<>();
    public Iterator(TreeNode root) {
        while (root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        TreeNode node = top.right;
        while (node!=null) {
            stack.push(node);
            node = node.left;
        }
        return top.data;
    }

    public int current() {
        return stack.peekFirst().data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}