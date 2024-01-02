package strivers.dp.DPonStrings;

import strivers.App;

//https://www.codingninjas.com/studio/problems/print-longest-common-subsequence_8416383
public class PrintLongestCommonSubSequence  implements App {


    @Override
    public void run() {
        String s1 = "abcde", s2 = "acbe";
        String res = findLCS(s1.length(), s2.length(), s1, s2);
        System.out.println(res);
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        int[][] dp = getDpArray(s1, s2);
        StringBuilder sb = new StringBuilder();

        int i = n, j = m;
        while (i>0 && j>0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        return sb.reverse().toString();
    }

    private static int[][] getDpArray(String s, String t) {
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
        return dp;
    }
}
