package strivers.dp.DpOnSubSequence;

import strivers.App;

//https://www.codingninjas.com/studio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum._842494
public class PartitionSumEqualsKII implements App {

    @Override
    public void run() {
        int[] arr = {4,3,2,1};
        int k = 5;
        int n = arr.length;
        int res = minSubsetSumDifference(arr, n);
        System.out.println(res);
    }

    // it will only work for positive values
    // if we get negative values, during the time of finding the result from dp array
    // (or map as we use negative values) we will not be sure whether the 0 is made of entire array or the particular subsequence
    public static int minSubsetSumDifference(int []arr, int n) {
        // use subset sum equals k dp approach
        int sum = 0;
        for (int element : arr) sum+=element;

        // if sum = 5, dp[0] = gives res for 5, dp[1] gives res for 4, dp[2] gives res for 3...
        boolean[] dp = getDPArray(n, sum, arr);

        // for sum 1 to 5 we have to check for the |s1 - s2| as minimal as possible
        int res = sum;

        // after half an array we will get the other half of the s1 so i limit can be till sum/2
        for(int i=0;i<=sum/2;i++) {
            if (dp[sum - i]) {
                res = Math.min(res, Math.abs(sum-i - (i)));
            }
        }
        return res;
    }

    private static boolean[] getDPArray(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n+1][k+1];

        for(int i=n;i>=0;i--) dp[i][k] = true;
        for (int i=n-1;i>=0;i--) {
            for (int sum=k;sum>=0;sum--) {
                if (sum + arr[i] <= k && dp[i+1][sum+arr[i]]) dp[i][sum] = true;
                else dp[i][sum] = dp[i+1][sum];
            }
        }
        return dp[0];
    }
}
