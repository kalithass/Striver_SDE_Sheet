package strivers.Trie.problems.CountDistincTSubstrings;

public class Trie {

    Node parent;
    int count;

    Trie() {
        parent = new Node();
    }

    void insertAndUpdateCount(String s) {
        for (int i = 0; i < s.length(); i++) {
            Node current = parent;
            for(int j=i;j<s.length();j++) {
                int index = s.charAt(j) - 'a';
                if(current.isEmpty(index)) {
                    this.count++;
                    current.createNode(index);
                }
                current = current.getNode(index);
            }
        }
    }
}
