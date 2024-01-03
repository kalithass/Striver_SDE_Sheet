package strivers.dp.dpOnLIS;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/longest-bitonic-sequence_1062688
public class LongestIncreasingBitonicSequence implements App {

    @Override
    public void run() {
        int[] arr = {1, 2, 4,3, 1};
        int n = arr.length;
        int res = longestBitonicSequence(arr, n);
        System.out.println(res);
    }


    public static int longestBitonicSequence(int[] arr, int n) {
        return doublePass(arr, n);
    }

    private static int doublePass(int[] arr, int n) {
        int[] right = lisFromRight(arr, n); // LDS -> Longest decreasing subsequence
        int[] left = licFromLeft(arr, n); // LIS -> Longest Increasing subsequence
//        System.out.println(Arrays.toString(right));
//        System.out.println(Arrays.toString(left));
        int max = 1;
        for(int i=0;i<n;i++) {
            max = Math.max(max, right[i]+left[i]-1);
        }
        return max;
    }

    private static int[] licFromLeft(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        return res;
    }

    private static int[] lisFromRight(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        return res;
    }
}
