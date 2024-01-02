package strivers.dp.DpOnSubSequence;


import strivers.App;

//https://www.codingninjas.com/studio/problems/target-sum_4127362
public class TargetSum implements App {


    @Override
    public void run() {
        int[] arr = {4,3,2,1};
        int target = 4;
        int n = arr.length;
        int res = findTargetSumWays(arr, target);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] ar, int t) {
        return findTargetSumWaysSpaceOptimized(ar, t);
    }

    /*
        {1,2,3} -> if we carefully observe it is asking us to find s1 - s2 = d
        s1 is amount, hence finding count of s2 is enough

     */
    private int findTargetSumWaysSpaceOptimized(int[] coins, int amount) {
        int sum = 0;
        for (int i : coins) {
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
        int s2 = (sum-amount)/2;
        // we cannot find negative or decimal sum on array
        if(sum-amount<0 || (sum-amount)%2 == 1) return 0;
        return helper(coins, s2);
    }

    private int helper(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            int[] temp = new int[k+1];
            for (int target = k; target >=0; target--) {
                int notPick = dp[target];
                int pick = 0;
                if(arr[i] <= target) {
                    pick = dp[target-arr[i]];
                }
                temp[target] = pick + notPick;
            }
            dp = temp;
        }
        return dp[k];
    }
}
