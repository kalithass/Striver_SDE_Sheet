package strivers.dp.DPonStrings;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSequence implements App {


    @Override
    public void run() {
        String text1 = "abcde", text2 = "ace";
        int res = numDistinct(text1, text2);
        System.out.println(res);
    }

    public int numDistinct(String s, String t) {
//        return recursiveApproach(s,t);
        return dpApproach(s, t);
    }

    private int dpApproach(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[][] dp = new long[n+1][m+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][ j - 1] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[n][m] > Integer.MAX_VALUE) return -1;
        return (int)dp[n][m];
    }

    private int recursiveApproach(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursiveHelper(s, t, n , m , dp);
    }

    private int recursiveHelper(String s, String t, int i, int j, int[][] dp) {
        // all the characters in t got matched
        if (j < 1) return 1;

        // few characters in t yet to be matched
        if (i < 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i-1) == t.charAt(j-1)) {
            return recursiveHelper(s, t, i - 1, j - 1, dp) + recursiveHelper(s, t, i - 1, j, dp);
        }
        return dp[i][j] = recursiveHelper(s, t, i - 1, j, dp);
    }
}
