package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/partitions-with-given-difference_3751628
public class CountPartitions implements App {

    @Override
    public void run() {
        int[] arr = {4,3,2,1};
        int d = 5;
        int n = arr.length;
        int res = countPartitions(n,d,arr);
        System.out.println(res);
    }

    public static int countPartitions(int n, int d, int[] arr) {
        // CountSubsetSumsWithK
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        /*

            s1 -s2 = d --> eq 1

            s1 + s2 = sum
            s1 = sum -s2 ---> eq 2

            apply eq 2 on eq 1

            sum - s2 - s2 = d
            sum - 2s2 = d
            sum = d+2s2
            sum - d = 2s2
            s2 = (sum-d) / 2
            hence finding s2 is enough
         */
        int s2 = (sum-d)/2;
        // we cannot find negative or decimal sum on array
        if(sum-d<0 || (sum-d)%2 == 1) return 0;
        return dpApproach(arr, s2);
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
}
