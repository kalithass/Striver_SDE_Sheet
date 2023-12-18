package strivers.Trie.problems.implementTrie2;

//https://www.codingninjas.com/studio/problems/implement-trie_1387095
public class Trie {

    Node parent;

    public Trie() {
        parent = new Node();
    }

    public void insert(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i)-'a';
            if(current.isEmpty(index)) current.createNode(index);
            current = current.getNode(index);
            current.startsWith++;
        }
        current.endsWith++;
    }

    public int countWordsEqualTo(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i)-'a';
            if(current.isEmpty(index)) return 0;
            current = current.getNode(index);
        }
        return current.endsWith;
    }

    public int countWordsStartingWith(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i)-'a';
            if(current.isEmpty(index)) return 0;
            current = current.getNode(index);
        }
        return current.startsWith;
    }

    public void erase(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i)-'a';
            current = current.getNode(index);
            current.startsWith--;
        }
        current.endsWith--;
    }
}
