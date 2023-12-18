package strivers.Trie.problems.maximumXorWithElementFromArray;

public class Trie {
    Node parent;

    Trie() {
        parent = new Node();
    }

    void insert(int num) {
        Node current = parent;
        for (int i = 31; i >= 0; i--) {
            int index = (num >> i) & 1;
            if (current.isEmpty(index)) current.createNode(index);
            current = current.getNode(index);
        }
    }

    int getMax(int num) {
        Node current = parent;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.isEmpty(1 - bit)) {
                current = current.getNode(bit);
            } else {
                res = res | (1 << i);
                current = current.getNode(1 - bit);
            }
        }
        return res;
    }
}
