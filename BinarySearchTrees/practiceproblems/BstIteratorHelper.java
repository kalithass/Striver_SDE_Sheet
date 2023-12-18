package strivers.BinarySearchTrees.practiceproblems;

import strivers.App;
import strivers.BinarySearchTrees.TreeNode;

import java.util.*;

//https://www.codingninjas.com/studio/problems/merge-two-bsts_920474
public class BstIteratorHelper implements App {

    @Override
    public void run() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bSTIterator = new BSTIterator(root);
        print(bSTIterator.next());    // return 3
        print(bSTIterator.next());    // return 7
        print(bSTIterator.hasNext()); // return True
        print(bSTIterator.next());    // return 9
        print(bSTIterator.hasNext()); // return True
        print(bSTIterator.next());    // return 15
        print(bSTIterator.hasNext()); // return True
        print(bSTIterator.next());    // return 20
        print(bSTIterator.hasNext()); // return False
    }

    private void print(Object val) {
        System.out.println(val);
    }
}

class BSTIterator {
    Deque<TreeNode> stack = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        pushLeftElements(root);
    }

    public int next() {
        TreeNode top = stack.pop();
        pushLeftElements(top.right);
        return top.val;
    }

    private void pushLeftElements(TreeNode root) {
        while (root !=null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
