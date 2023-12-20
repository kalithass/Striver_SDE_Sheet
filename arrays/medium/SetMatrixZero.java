package strivers.arrays.medium;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero implements App {

    @Override
    public void run() {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void setZeroes(int[][] matrix) {
        // brute : set all the row and col as -1 and after that set all of them as 0 (nearly n*n*n time complexity)
        optimalApproach(matrix);
    }

    // use first row and column as the colArr and rowArr
    private void optimalApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // a[0][0] is shared by both row and col, hence create variable for the colArr
        // and use a[0][0] for rowArr
        int colFirst = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {

                    if (j == 0) {
                        colFirst = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }

        for (int col = 1; col < m; col++) {
            if (matrix[0][col] == 0) {
                fillColumn(matrix, col, n);
            }
        }


        for (int row = 0; row < n; row++) {
            if(matrix[row][0] == 0) {
                fillRow(matrix, row, m);
            }
        }

        if(colFirst == 0) {
            fillColumn(matrix, 0, n);
        }
    }

    // keep row and col to mark the particular row or col will be 0
    private void betterApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] colArr = new int[m];
        int[] rowArr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    colArr[j] = 1;
                    rowArr[i] = 1;
                }
            }
        }

        for (int col = 0; col < m; col++) {
            if (colArr[col] == 1) {
                fillColumn(matrix, col, n);
            }
        }

        for (int row = 0; row < n; row++) {
            if (rowArr[row] == 1) {
                fillRow(matrix, row, m);
            }
        }
    }

    private void fillColumn(int[][] matrix, int col, int n) {
        for (int row = 0; row < n; row++) {
            matrix[row][col] = 0;
        }
    }

    private void fillRow(int[][] mat, int row, int m) {
        Arrays.fill(mat[row], 0);
    }

}
