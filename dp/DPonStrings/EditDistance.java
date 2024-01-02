package strivers.dp.DPonStrings;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/edit-distance/
public class EditDistance implements App {


    @Override
    public void run() {
        String text1 = "abcde", text2 = "ace";
        int res = minDistance(text1, text2);
        System.out.println(res);
    }

    public int minDistance(String word1, String word2) {
        return recursiveApproach(word1, word2);
    }

    private int recursiveApproach(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursiveHelper(word1, word2, n1, n2, dp);
    }

    private int recursiveHelper(String s, String t, int i, int j, int[][] dp) {

        // i exhausted
        if (i == 0) return j;

        // j exhausted
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i-1) == t.charAt(j-1)) {
            return dp[i][j] = recursiveHelper(s,t,i-1, j-1, dp);
        } else {
            int insert =  1 + recursiveHelper(s, t, i, j-1, dp);
            int replace = 1 + recursiveHelper(s, t, i-1, j-1, dp);
            int delete =  1 + recursiveHelper(s, t, i-1, j, dp);
            return dp[i][j] = Math.min(replace, Math.min(delete, insert));
        }
    }
}
