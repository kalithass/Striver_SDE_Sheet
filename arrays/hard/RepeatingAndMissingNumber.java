package strivers.arrays.hard;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/missing-and-repeating-numbers_6828164
public class RepeatingAndMissingNumber implements App {

    @Override
    public void run() {
        int[] nums = {1,2,3,2};
        int goal = 11;
        int[] res = findMissingRepeatingNumbers(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findMissingRepeatingNumbers(int []a) {
//        return optimalApproach1(a);
        return optimalApproach2(a);
    }

    private static int[] optimalApproach2(int[] a) {
        int xor = 0;
        // inside loop ((1^2^..n) ^ (a[0] ^ a[1]^... a[n-1])
        for(int i = 0; i< a.length; i++) {
            xor ^= a[i];
            xor ^= i+1;
        }
        int p = getFirstSetBit(xor);
        int oneGroup= 0, zeroGroup=0;

        for(int i=0;i<a.length;i++) {
            if ((a[i] & (1 << p)) != 0) oneGroup ^= a[i];
            else zeroGroup ^= a[i];

            if(((i+1) & (1<<p)) != 0) oneGroup ^= i+1;
            else zeroGroup ^= i+1;
        }

        for (int j : a) {
            if (oneGroup == j) return new int[]{oneGroup, zeroGroup};
        }
        return new int[]{zeroGroup,oneGroup};
    }

    private static int getFirstSetBit(int xor) {
        int p = 0;
        while(xor > 0) {
            if(xor %2 == 1) {
                break;
            }
            else {
                xor /= 2;
                p++;
            }
        }
        return p;
    }

    public static int[] optimalApproach1(int []a) {
        long n = a.length;
        long sn = (n*(n+1))/2;
        long s2n = (n  * (n+1) * ((2*n)+1)) / 6;
        long s = 0;
        long s2 = 0;
        for (int j : a) {
            s += j;
            s2 += ((long) j * j);
        }
        long xmy = sn-s; // x-y
        long x2my2 = s2n-s2; // (x+y)(x-y)
        long xpy = x2my2 / xmy; // (x+y)
        int x = (int)((xmy+xpy)/2);
        int y = (int) (xpy-x);
        return new int[]{y,x};
    }
}
