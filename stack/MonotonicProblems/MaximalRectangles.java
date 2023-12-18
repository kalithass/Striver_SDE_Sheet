package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangles implements App {

    @Override
    public void run() {
//        int{} heights = {2, 1, 5, 6, 2, 3};
//        char[][] matrix = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };

        char[][] matrix = {
                {'0', '0', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '1', '1'}
        };

        int res = maximalRectangle(matrix);
        System.out.println(res);
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = Integer.MIN_VALUE;


        for(int row=0;row<matrix.length;row++) {
            for(int i=0;i<n;i++) {
                if(matrix[row][i] != '0') heights[i] += matrix[row][i] - '0';
                else  heights[i] = 0;
            }
            max = Math.max(max, findMaxHeight(heights));
            System.out.println(Arrays.toString(heights)+" "+max);
        }
        return max;
    }

    private int findMaxHeight(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int val = heights[i];
            while (!stack.isEmpty() && val <= heights[stack.peek()]) {
                int element = stack.pop();
                int leftSmall = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i-leftSmall-1) * heights[element]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int element = stack.pop();
            int leftSmall = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (n-leftSmall-1) * heights[element]);
        }
        return max;
    }


}
