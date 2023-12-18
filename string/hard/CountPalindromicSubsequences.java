package strivers.string.hard;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/count-palindromic-subsequences_1062696
public class CountPalindromicSubsequences implements App {

    @Override
    public void run() {
        String text = "abab";
        int res = countPalindromicSubseq(text);
        System.out.println(res);
    }

    // a b a b aa bb aba bab

    public static int countPalindromicSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) Arrays.fill(dp[i], -1);
//        for (int[] ar : dp) System.out.println(Arrays.toString(ar));
        return recursiveHelper(s, 0, s.length()-1, dp);
    }

    private static int recursiveHelper(String s, int i, int j, int[][] dp) {
        if(i>j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = (1 + recursiveHelper(s, i+1, j, dp) + recursiveHelper(s, i, j-1, dp)) % 1000000007;
        return dp[i][j] =  (recursiveHelper(s, i+1, j, dp) + recursiveHelper(s, i, j-1, dp) - recursiveHelper(s, i+1, j-1, dp)) % 1000000007;
    }
}
