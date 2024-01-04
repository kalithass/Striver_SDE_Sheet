package strivers.dp.MCM;

import strivers.App;
import strivers.Main;

import java.util.Arrays;

//https://leetcode.com/problems/partition-array-for-maximum-sum/
public class PartitionArrayForMaximum implements App {

    @Override
    public void run() {
        int[] arr = {1,15,7,9,2,5,10};
        int k=3;
        int res = maxSumAfterPartitioning(arr, k);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        return recursiveApproach(arr, k);
    }

    private int recursiveApproach(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursiveHelper(arr, 0, k, dp);
    }

    private int recursiveHelper(int[] arr, int i, int k,int[] dp) {
        if (i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int res = 0;
        int max = arr[i];
        int n = Math.min(arr.length, i+k);
        for (int j = i;j< n;j++) {
            max = Math.max(max, arr[j]);
            int curr = (max * (j-i+1)) + recursiveHelper(arr, j+1, k, dp);
            res = Math.max(res, curr);
        }
        return dp[i] = res;
    }
}
