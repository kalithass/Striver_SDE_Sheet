package strivers.dp.DPonStrings;

import strivers.App;

//https://leetcode.com/problems/shortest-common-supersequence/
public class ShortestCommonSuperSequence implements App {


    @Override
    public void run() {
        String text1 = "abcde", text2 = "ace";
        String res = shortestCommonSupersequence(text1, text2);
        System.out.println(res);
    }

    // if length is asked return sLen + tLen - len(lcs)
    public String shortestCommonSupersequence(String s, String t) {
        int[][] dp = getDPArray(s,t);
        int n1 = s.length(), n2 = t.length();
        StringBuilder sb = new StringBuilder();
        int i=n1, j=n2;

        while(i>0 && j>0) {
            if(s.charAt(i-1) == t.charAt(j-1)) {
                sb.append(s.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                sb.append(s.charAt(i-1));
                i--;
            } else {
                sb.append(t.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            sb.append(s.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(t.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }

    private int[][] getDPArray(String s, String t) {
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
