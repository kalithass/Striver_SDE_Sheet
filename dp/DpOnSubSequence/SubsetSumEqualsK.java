package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954
public class SubsetSumEqualsK implements App {

    @Override
    public void run() {
        int[] arr = {4,3,2,1};
        int k = 5;
        int n = arr.length;
        boolean res = subsetSumToK(n, k, arr);
        System.out.println(res);
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
//        return recursiveApproach(n, k, arr);
        return dpApproach(n, k, arr);
    }

    private static boolean dpApproach(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n+1][k+1];

        for(int i=n;i>=0;i--) dp[i][k] = true;
        for (int i=n-1;i>=0;i--) {
            for (int sum=k;sum>=0;sum--) {
                if (sum + arr[i] <= k && dp[i+1][sum+arr[i]]) dp[i][sum] = true;
                else dp[i][sum] = dp[i+1][sum];
            }
        }
        return dp[0][0];
    }

    private static boolean recursiveApproach(int n, int k, int[] arr) {
        int[][] dp = new int[n][k];
        for(int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(0, 0, arr, k, dp);
    }

    private static boolean recursiveHelper(int i, int sum, int[] arr, int k, int[][] dp) {
        if (sum == k) return true;
        if (i == arr.length) return false;

        if (dp[i][sum] != -1) return dp[i][sum] == 0 ? false : true;
        if (sum + arr[i] <= k) {
            boolean res = recursiveHelper(i+1, sum+arr[i], arr, k, dp);
            dp[i][sum] = res ? 1 : 0;
            if (res) return true;
        }
        boolean res = recursiveHelper(i+1, sum, arr, k, dp);
        dp[i][sum] = res ? 1 : 0;
        return res;
    }
}
