package strivers.arrays.hard;

public class MaximumProductSubArray {

    public int maxProduct(int[] a) {
//        return optimalApproach1(a);
        return optimalApproach2(a); // extended Kaden's algorithm
    }

    // https://leetcode.com/problems/maximum-product-subarray/solutions/3321410/c-kadane-s-algo-full-explanation/
    private int optimalApproach2(int[] a) {
        int leftProd = Integer.MIN_VALUE;
        int n = a.length;

        int tempLeft = 1;
        for (int i = 0; i < n; i++) {
            tempLeft = tempLeft * a[i];
            leftProd = Math.max(tempLeft, leftProd);
            if (tempLeft == 0) tempLeft = 1;
        }

        int rightProd = Integer.MIN_VALUE;
        int tempRight = 1;
        for (int i = n - 1; i >= 0; i--) {
            tempRight = tempRight * a[i];
            rightProd = Math.max(rightProd, tempRight);
            if(tempRight == 0) tempRight = 1;
        }
        return Math.max(leftProd, rightProd);
    }

    private int optimalApproach1(int[] a) {
        int max = Integer.MIN_VALUE;
        int n = a.length;
        int prefix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {
            prefix *= a[i];
            suffix *= a[n - i - 1];
            max = max(prefix, suffix, max);
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
        }
        return max;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
