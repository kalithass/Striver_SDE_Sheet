package strivers.dp.DPonStrings;

import strivers.App;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class MinInsertionToMakeStringPalindrome implements App {


    @Override
    public void run() {
        String s = "bbbab";
        int res = minInsertions(s);
        System.out.println(res);
    }

    public int minInsertions(String s) {
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = getDpArray(s,t);
        return n - dp[n][n];
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
