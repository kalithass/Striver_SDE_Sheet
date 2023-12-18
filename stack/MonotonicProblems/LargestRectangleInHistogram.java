package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram implements App {

    @Override
    public void run() {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2,3};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }

    public int largestRectangleArea(int[] heights) {
        return optimalApproach(heights);
//        return twoStackApproach(heights);
    }

    private int optimalApproach(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++) {
            int val = heights[i];
            while (!stack.isEmpty() && val <= heights[stack.peek()]) {
                int element = stack.pop();
                int leftSmall = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i -leftSmall-1)*heights[element]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int element = stack.pop();
            int leftSmall  = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (n-leftSmall-1) * heights[element]);
        }
        return max;
    }

    private int twoStackApproach(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] ple = getPLE(heights, n);
        int[] nse = getNSE(heights, n);
//        System.out.println(Arrays.toString(ple));
//        System.out.println(Arrays.toString(nse));
        for(int i=0;i<n;i++) {
            res = Math.max(res, (nse[i]-ple[i]-1) * heights[i]);
        }
        return res;
    }

    private int[] getNSE(int[] heights, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            int val = heights[i];
            while (!stack.isEmpty() && val <= heights[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    private int[] getPLE(int[] heights, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int val = heights[i];
            while (!stack.isEmpty() && val <= heights[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
