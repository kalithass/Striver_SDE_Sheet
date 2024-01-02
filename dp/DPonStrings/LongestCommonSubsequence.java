package strivers.dp.DPonStrings;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence  implements App {


    @Override
    public void run() {
        String text1 = "abcde", text2 = "ace";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // return recursiveApproach(text1, text2);
        return dpApproach(text1, text2);
    }

    private int dpApproach(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
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
        return dp[n1][n2];
    }

    private int recursiveApproach(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(s, t, s.length(), t.length(), dp);
    }

    private int recursiveHelper(String s, String t, int i, int j, int[][] dp) {
        if (i == 0 || j== 0 ) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i-1) == t.charAt(j-1)) return 1 + recursiveHelper(s, t, i-1, j-1, dp);
        return dp[i][j] = Math.max(recursiveHelper(s, t, i-1, j, dp), recursiveHelper(s, t, i, j-1, dp));
    }
}
