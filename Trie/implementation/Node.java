package strivers.Trie.implementation;

 class Node {

    Node[] arr;
    boolean isEnd;


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

    void setEnd() {
        this.isEnd = true;
    }

}
