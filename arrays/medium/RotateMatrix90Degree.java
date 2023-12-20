package strivers.arrays.medium;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/
public class RotateMatrix90Degree implements App {

    @Override
    public void run() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        optimalApproach(matrix);
    }

    // transpose and reverse each row
    private void optimalApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        transposeTheMatrix(matrix, n, m);
        for(int row=0;row<n;row++) {
            reverseRow(matrix, row, m);
        }
    }

    void reverseRow(int[][] mat, int row, int m) {
        int start = 0;
        int end = m-1;
        while (start < end) {
            swap(mat, row, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[][] mat, int row, int start, int end) {
        int temp = mat[row][start];
        mat[row][start] = mat[row][end];
        mat[row][end] = temp;
    }

    private void transposeTheMatrix(int[][] matrix, int n, int m) {
        for (int i = 0; i<n;i++) {
            for(int j=0;j<m;j++) {
                swap(matrix, i, j);
            }
        }
    }

    void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
