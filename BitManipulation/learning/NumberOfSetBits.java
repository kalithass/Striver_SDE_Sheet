package strivers.BitManipulation.learning;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/count-total-set-bits_784
public class NumberOfSetBits implements App {

    @Override
    public void run() {
        int num = 4;
        int res = countSetBits(num);
        System.out.println(res);
    }

    public static int countSetBits(int n) {
//        return naiveApproach(n);
        return dpApproach(n);
    }

    private static int dpApproach(int n) {
        int[] arr = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = i%2 + arr[i/2];
            res += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }

    private static int naiveApproach(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) res += getCountOfOnes(i);
        return res;
    }

    private static int getCountOfOnes(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
