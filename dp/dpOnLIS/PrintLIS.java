package strivers.dp.dpOnLIS;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/printing-longest-increasing-subsequence_8360670
public class PrintLIS implements App {


    @Override
    public void run() {
        int[] arr = {5,6,3,4,7,6};
        int x = arr.length;
        List<Integer> res = printingLongestIncreasingSubsequence(arr, x);
        System.out.println(res);
    }

    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        return getUsingDpArray(arr, x);
    }

    private static List<Integer> getUsingDpArray(int[] arr, int n) {

        int max = 1;
        int maxi = 0;

        int[] dp = new int[n];
        int[] prev = new int[n];

        for (int i=0;i<n;i++) {
            int ans = 1;
            prev[i] = i;
            for (int j=i-1;j>=0;j--) {
                if (arr[i] > arr[j]) {
                    // ans = Math.max(ans, 1+dp[j]);
                    if (ans < 1+ dp[j]) {
                        ans = 1+dp[j];
                        prev[i] = j;
                    }

                    // max = Math.max(max, ans);
                    if (ans > max) {
                        max = ans;
                        maxi = i;
                    }
                }
            }
            dp[i] = ans;
        }

        List<Integer> res = new ArrayList<>();
        res.add(arr[maxi]);

        System.out.println(Arrays.toString(dp));
        System.out.println();
        System.out.println(Arrays.toString(prev));

        int ind = maxi;

        while (ind != prev[ind]) {
            ind = prev[ind];
            res.add(arr[ind]);
        }

        Collections.reverse(res);

        return res;
    }
}
