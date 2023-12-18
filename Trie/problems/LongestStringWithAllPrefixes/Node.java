package strivers.Trie.problems.LongestStringWithAllPrefixes;

public class Node {

    Node[] arr;
    boolean isEnd;

    Node() {
        arr = new Node[26];
    }

    void setEnd() {
        this.isEnd = true;
    }

    boolean isEmpty(int index) {
        return arr[index] == null;
    }

    void createNode(int index) {
        arr[index] = new Node();
    }

    Node getNode(int index) {
        return arr[index];
    }

}
