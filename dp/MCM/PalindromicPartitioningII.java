package strivers.dp.MCM;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromicPartitioningII implements App {

    @Override
    public void run() {
        String s = "abcccb";
        int res = minCut(s);
        System.out.println(res);
    }

    public int minCut(String s) {
        // result will give number of pieces, so we need to give the cuts ( which is res -1)
//        return recursiveApproach(s) -1 ;
        return dpApproach(s) - 1;
    }

    private int dpApproach(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        boolean[][] palindromeTable = getPalindromeTable(s, n);
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int k = i; k <= n - 1; k++) {
                if (palindromeTable[i][k]) {
                    int rightPartition = dp[k + 1];
                    if (rightPartition != Integer.MAX_VALUE) min = Math.min(min, rightPartition + 1);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    // https://www.youtube.com/watch?v=_H8V5hJUGd0&t=8s
    private boolean[][] getPalindromeTable(String s, int n) {
        boolean[][] table = new boolean[n][n];

        for (int i = 0; i < n; i++) table[i][i] = true;
        for (int i = 0; i < n - 1; i++) table[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

        for (int i=n-1;i>=0;i--) {
            for (int j = i+2; j < n; j++) {
                table[i][j] = (s.charAt(i) == s.charAt(j)) &&
                        table[i + 1][j - 1]; // left lower diagonal
            }
        }
        return table;
    }

    private int recursiveApproach(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursiveHelper(s, 0, n - 1, dp);
    }

    private int recursiveHelper(String s, int i, int n, int[] dp) {
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= n; k++) {
            if (isPalindrome(s, i, k)) {
                int rightPartition = recursiveHelper(s, k + 1, n, dp);
                if (rightPartition != Integer.MAX_VALUE) min = Math.min(min, rightPartition + 1);
            }
        }
        return dp[i] = min;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
