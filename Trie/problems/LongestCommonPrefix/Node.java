package strivers.Trie.problems.LongestCommonPrefix;

 class Node {

    Node[] arr;
    boolean isEnd;

    int endsWith;

    int startsWith;


    Node() {
        arr = new Node[26];
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
