package strivers.binearysearch.on2dArrays;

import strivers.App;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchIn2dMatrixII implements App {

    @Override
    public void run() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {20, 30, 34, 60}};
        int target = 3;
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return optimalApproach1(matrix, target);
        // return optimalApproach2(matrix, target);
    }

    private boolean optimalApproach2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = n-1, col = 0;
        while (col<m && row>=0) {
            if (matrix[row][col] == target) return true;
            if(matrix[row][col] > target) row--;
            else col++;
        }
        return false;
    }

    private boolean optimalApproach1(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row= 0, col = m-1;
        while (col >= 0 && row <n) {
            if (matrix[row][col] == target) return true;
            if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
