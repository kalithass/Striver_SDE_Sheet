package strivers.dp.DPonStrings;

import strivers.App;

//https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence implements App {


    @Override
    public void run() {
        String s = "bbbab";
        int res = longestPalindromeSubseq(s);
        System.out.println(res);
    }

    public int longestPalindromeSubseq(String s) {
        return lcs(s, new StringBuilder(s).reverse().toString());
    }

    private int lcs(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[][] dp = getDpArray(s,t);
        return dp[n1][n2];
    }

    private int[][] getDpArray(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1;i<=n1;i++) {
            for (int j=1;j<=n2;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }
}
