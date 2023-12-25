package strivers.binearysearch.on2dArrays;

import strivers.App;

//https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473
public class MedianInAMatrix implements App {

    @Override
    public void run() {
//        int[][] matrix = {{1, 5, 7, 9, 11}, {2, 3, 4, 8, 9}, {4, 11, 14, 19, 20}, {6, 10, 22, 99, 100}, {7, 5, 17, 24, 28}};
        int[][] matrix = {
                {1, 2, 3},
                {4, 9, 11},
                {13, 14, 15}
        };
        int res = findMedian(matrix, matrix.length, matrix[0].length);
        System.out.println(res);
    }

    public static int findMedian(int matrix[][], int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i =0;i<m;i++) {
            for (int j=0;j<n;j++) {
                low = Math.min(matrix[i][j], low);
                high = Math.max(matrix[i][j], high);
            }
        }
        int midPosition = ((m*n)/2) + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = numberOfElementsLessThanOrEqualTo(mid, matrix);
            if (count >= midPosition) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private static int numberOfElementsLessThanOrEqualTo(int element, int[][] matrix) {
        int count = 0;
        for (int[] arr : matrix) {
            count += upperBound(arr, element);
        }
        return count;
    }

    // index of first value which is greater than element
    private static int upperBound(int[] arr, int element) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= element) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
