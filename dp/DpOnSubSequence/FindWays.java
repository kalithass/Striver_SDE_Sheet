package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/count-subsets-with-sum-k_3952532
public class FindWays implements App {

    static int mod = 1000000007;

    @Override
    public void run() {
        int[] arr = {1,1,4,5};
        int tar = 5;
        int res = findWays(arr, tar);
        System.out.println(res);
    }

    // it will work for array with 0 as well
    public static int findWays(int num[], int tar) {
        //    return recursiveApproach(num, tar);
        return dpApproach(num, tar);
    }

    private static int dpApproach(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n+1][tar+1];

        for(int i=n;i>=0;i--) dp[i][tar] = 1;
        for (int i=n-1;i>=0;i--) {
            for (int sum = tar;sum>=0;sum--) {
                int res = 0;
                if (sum + num[i] <= tar) {
                    res = dp[i+1][sum+num[i]] % 1000000007;
                }
                dp[i][sum] = res + dp[i+1][sum] % 1000000007;
            }
        }
        return dp[0][0] % 1000000007;
    }

    private static int recursiveApproach(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n+1][tar+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(0,0, tar, num, dp)%mod;
    }

    private static int recursiveHelper(int i, int sum, int tar, int[] num, int[][] dp) {
        if(sum == tar) return 1;
        if (i == num.length) return 0;

        if (dp[i][sum] != -1) return dp[i][sum];
        int res = 0;
        if (sum + num[i] <= tar) {
            res = recursiveHelper(i+1, sum+num[i], tar, num, dp)%mod;
        }
        return dp[i][sum] = res + recursiveHelper(i+1, sum, tar, num, dp)%mod;
    }
}
