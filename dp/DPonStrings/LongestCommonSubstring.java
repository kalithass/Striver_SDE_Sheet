package strivers.dp.DPonStrings;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/longest-common-substring_1235207
public class LongestCommonSubstring implements App {


    @Override
    public void run() {
        String s1 = "abcde", s2 = "ace";
        int res = lcs(s1, s2);
        System.out.println(res);
    }

    public static int lcs(String s1, String s2){
//        return recursiveApproach(s1, s2);
        return dpApproach(s1,s2);
    }

    private static int dpApproach(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        int res = 0;
        for(int i=1;i<=n1;i++) {
            for (int j=1;j<=n2;j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] =  1 + dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    static int max = 0;

    private static int recursiveApproach(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        max = 0;
        int[][] dp = new int[n1+1][n2+1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        recursiveHelper(s1, s2, n1, n2, dp);
        return max;
    }

    private static int recursiveHelper(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            ans = 1 + recursiveHelper(s1, s2, i - 1, j - 1, dp);
            max = Math.max(max, ans);
        }
        recursiveHelper(s1, s2, i, j - 1, dp);
        recursiveHelper(s1, s2, i - 1, j, dp);
        return dp[i][j] = ans;
    }
}
