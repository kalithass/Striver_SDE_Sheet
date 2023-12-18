package strivers.Trie.problems.LongestStringWithAllPrefixes;

import strivers.App;

import java.lang.ref.SoftReference;

//https://www.codingninjas.com/studio/problems/complete-string_2687860
public class LongestStringWithAllPrefixes implements App {

    @Override
    public void run() {
        String[] arr = {"n", "ni", "nin", "ninja", "ninj"};
        int n = arr.length;
        String res = completeString(n, arr);
        System.out.println(res);
    }

    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for(String s : a) {
            trie.insert(s);
        }

        String res = "";
        for(String s : a) {
            if(trie.isAllWordsPresent(s) && s.length() >= res.length()) res = s;
        }

        return res.equals("") ? "None" : res ;
    }
}
