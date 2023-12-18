package strivers.BinarySearchTrees.concepts;


import strivers.App;
import strivers.BinarySearchTrees.Node;

//https://www.codingninjas.com/studio/problems/minimum-element-in-bst_8160462?leftPanelTabValue=PROBLEM
public class FindMin implements App {

    @Override
    public void run() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        int res = minValue(root);
        System.out.println(res);
    }

    public static int minValue(Node root) {
        int res = -1;
        while (root != null) {
            res = root.data;
            root = root.left;
        }
        return res;
    }

}
