package strivers.Trie.implementation;

//https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {

    Node parent;

    public Trie() {
        parent = new Node();
    }

    public void insert(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(current.isEmpty(index)) current.createNode(index);
            current = current.getNode(index);
        }
        current.setEnd();
    }

    public boolean search(String word) {
        Node current = parent;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(current.isEmpty(index)) return false;
            current = current.getNode(index);
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node current = parent;
        for(int i=0;i<prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';
            if(current.isEmpty(index)) return false;
            current = current.getNode(index);
        }
        return true;
    }
}