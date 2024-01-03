package strivers.dp.dpOnLIS;

import strivers.App;
import strivers.Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain implements App {

    @Override
    public void run() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int res = longestStrChain(words);
        System.out.println(res);
    }

    public int longestStrChain(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int n = words.length;

        int res = 1;
        int[] dp = new int[n];

        for (int i=0;i<n;i++) {
            int ans = 1;
            for (int j=i-1;j>=0;j--) {
                if (isOneCharacterShort(words[i], words[j])) {
                    ans = Math.max(ans, 1+dp[j]);
                    res = Math.max(res, ans);
                }
            }

            dp[i] = ans;
        }
        return res;
    }

    private boolean isOneCharacterShort(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n-m != 1) return false;

        int i=0, j=0;
        while (i<n) {
            if (j<m && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else i++;
        }
        if (i == n && j==m) return true;
        return false;
    }
}
