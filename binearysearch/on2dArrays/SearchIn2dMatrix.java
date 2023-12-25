package strivers.binearysearch.on2dArrays;

import strivers.App;

//https://leetcode.com/problems/search-a-2d-matrix/description/
public class SearchIn2dMatrix implements App {

    @Override
    public void run() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{20,30,34,60}};
        int target = 3;
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
//        return optimalApproach1(matrix, target);
        return optimalApproach2(matrix, target);
    }

    private boolean optimalApproach2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        /*
              . . . .
              . . . .
              . . . .
         */
        // n = 3, m = 4 => high = 11, i = 11/4, j = 11%4
        int low = 0, high = n*m -1;
        while (low <= high) {
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }

    private boolean optimalApproach1(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if(row == -1) return false;
        return findColumn(matrix, target, row);
    }

    private boolean findColumn(int[][] matrix, int target, int row) {
        int low = 0, high = matrix[row].length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target) {
        int low = 0, high = matrix.length-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(matrix[mid][0] < target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return high;
    }
}
