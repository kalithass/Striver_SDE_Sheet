package strivers.Trie.problems.LongestStringWithAllPrefixes;

public class Trie {
    
    Node parent;
    
    Trie() {
        parent = new Node();
    }
    
    void insert(String word) {
        Node current = parent;
        for (int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(current.isEmpty(index)) current.createNode(index);
            current = current.getNode(index);
        }
        current.setEnd();
    }

    boolean isAllWordsPresent(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            current = current.getNode(index);
            if(!current.isEnd) return false;
        }
        return true;
    }
}
