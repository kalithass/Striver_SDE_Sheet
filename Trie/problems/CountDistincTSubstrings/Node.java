package strivers.Trie.problems.CountDistincTSubstrings;

public class Node {
    Node[] arr;
    Node() {
        arr = new Node[26];
    }

    boolean isEmpty(int index) {
        return arr[index] == null;
    }

    public void createNode(int index) {
        arr[index] = new Node();
    }

    public Node getNode(int index) {
        return arr[index];
    }
}
