package strivers.Trie.problems.LongestCommonPrefix;

import strivers.App;

//https://www.codingninjas.com/studio/problems/longest-common-prefix_2090383
public class LongestCommonPrefix implements App {

    @Override
    public void run() {
        String[] arr = {"cod", "coding", "coder", "codingninja"};
        String res = longestCommonPrefix(arr, arr.length);
        System.out.println(res);
    }
    public static String longestCommonPrefix(String[] arr, int n) {
        Trie trie = new Trie();
        for(String s : arr) trie.insert(s);
        int end = trie.getLongestPrefix(arr[0], n);
        return arr[0].substring(0, end);
    }
}
