package strivers.Trie.problems.MaximumXor;

public class Node {
    Node[] arr;
    Node() {
        arr = new Node[2];
    }

    boolean isEmpty(int index) {
        return arr[index] == null;
    }

    Node getNode(int index) {
        return arr[index];
    }

    void createNode(int index) {
        arr[index] = new Node();
    }
}
