package strivers.dp.DPonStrings;

import strivers.App;

//https://leetcode.com/problems/delete-operation-for-two-strings/
public class MinimumOperationToMakeTwoStringsSame implements App {


    @Override
    public void run() {
        String text1 = "sea", text2 = "tea";
        int res = minDistance(text1, text2);
        System.out.println(res);
    }
    public int minDistance(String word1, String word2) {
        int res = lcs(word1, word2);
        return word1.length()+word2.length()-res-res;
    }

    private int lcs(String s, String t) {
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
}
