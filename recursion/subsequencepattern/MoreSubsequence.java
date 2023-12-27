package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.HashMap;

//https://www.codingninjas.com/studio/problems/more-subsequence_8842355
public class MoreSubsequence implements App {

    @Override
    public void run() {
        int n = 2, m = 2;
        String a = "ab";
        String b = "dd";
        String res = moreSubsequence(n, m, a, b);
        System.out.println(res);
    }

    public static String moreSubsequence(int n, int m, String a, String b) {
        int distinctA = countDistinctSubSequences(a);
        int distinctB = countDistinctSubSequences(b);
        return distinctA > distinctB ? a : b;
    }

    static int countDistinctSubSequences(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int prev = hm.getOrDefault(ch, 0);
            hm.put(ch, res);
            res = res * 2 - prev;
        }
        return res;
    }
}
