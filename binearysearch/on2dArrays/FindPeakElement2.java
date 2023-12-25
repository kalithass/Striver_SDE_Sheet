package strivers.binearysearch.on2dArrays;

import strivers.App;

//https://leetcode.com/problems/find-a-peak-element-ii/
public class FindPeakElement2 implements App {

    @Override
    public void run() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {20, 30, 34, 60}};
        int target = 3;
        int[] res = findPeakGrid(matrix);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] findPeakGrid(int[][] mat) {
        return optimalApproach1(mat);
        // return optimalApproach2(mat);
    }

    private int[] optimalApproach2(int[][] mat) {
        int n = mat.length, col = mat[0].length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int midRow = (low + high) /2;
            int maxInd = 0;
            for(int i=0;i<col;i++) {
                if(mat[midRow][i] > mat[midRow][maxInd]) maxInd = i;
            }

            int top = -1, bottom = -1;
            if (midRow > 0) top = mat[midRow-1][maxInd];
            if (midRow < n-1) bottom = mat[midRow+1][maxInd];
            int element = mat[midRow][maxInd];
            if (element > top && element > bottom) return new int[]{midRow, maxInd};
            if(element > bottom) high = midRow-1;
            else low = midRow+1;
        }
        return new int[]{-1, -1};
    }

    private int[] optimalApproach1(int[][] mat) {
        // see the matrix as top view, hence we need larger element in each column and after that it is simply peakelement-1
        int n = mat.length, col = mat[0].length;
        int low = 0, high = col - 1;
        while (low <= high) {
            int midCol = (low + high) / 2;
            int maxInd = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxInd][midCol]) maxInd = i;
            }
            int left = -1, right = -1;
            if (midCol > 0) left = mat[maxInd][midCol - 1];
            if (midCol < col - 1) right = mat[maxInd][midCol + 1];

            int element = mat[maxInd][midCol];
            if (element > left && element > right) return new int[]{maxInd, midCol};
            else if (element > left) low = midCol + 1;
            else high = midCol - 1;
        }
        return new int[]{-1, -1};
    }
}
