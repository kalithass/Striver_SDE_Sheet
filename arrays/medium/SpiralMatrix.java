package strivers.arrays.medium;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix  implements App {

    @Override
    public void run() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top =0, right = matrix[0].length-1, left = 0, bottom = matrix.length-1;
        List<Integer> res = new ArrayList<>();
        while (top<=bottom && left<= right) {
            // loop through top
            for(int i=left;i<=right;i++) res.add(matrix[top][i]);

            // move top by 1 position
            top++;

            // loop through right
            for(int i=top;i<=bottom;i++) res.add(matrix[i][right]);

            // move right 1 position
            right--;

            // if top is <= bottom loop through bottom
            if(top <= bottom) {
                for(int i=right;i>=left;i--) res.add(matrix[bottom][i]);

                // move bottom 1 position
                bottom--;
            }

            // if left is<= right loop through right
            if(left<=right) {
                for(int i=bottom;i>=top;i--) res.add(matrix[i][left]);

                // move left 1 position
                left++;
            }
        }
        return res;
    }
}
