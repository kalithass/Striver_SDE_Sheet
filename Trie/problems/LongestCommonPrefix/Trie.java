package strivers.Trie.problems.LongestCommonPrefix;
class Trie {

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

    int getLongestPrefix(String s, int n) {
        Node current = parent;
        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i) - 'a';
            if(current.isEmpty(index) || current.getNode(index).startsWith != n) return i;
            current = current.getNode(index);
        }
        return s.length();
    }

}