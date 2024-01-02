package strivers.dp.DPonStrings;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/wildcard-matching/
public class WildCardMatching implements App {


    @Override
    public void run() {
        String text1 = "aa", text2 = "a";
        boolean res = isMatch(text1, text2);
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        return recursiveApproach(s, p);
    }

    private boolean recursiveApproach(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(s, p, n1, n2, dp);
    }

    private boolean recursiveHelper(String s, String p, int i, int j, int[][] dp) {

        if (i == 0 && j == 0) return true;

        // no chars left on p which means some unmatched chars on s
        if (j == 0) return false;


        if (i == 0) {
            for (int k=1;k<=j;k++) {
                if (p.charAt(k-1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;


        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            boolean res = recursiveHelper(s, p, i - 1, j - 1, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        if (p.charAt(j - 1) == '*') {
            boolean res = recursiveHelper(s, p, i - 1, j, dp) || recursiveHelper(s, p, i, j - 1, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        dp[i][j] = 0;
        return false;
    }
}
