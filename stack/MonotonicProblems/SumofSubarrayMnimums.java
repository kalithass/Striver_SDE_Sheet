package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumofSubarrayMnimums implements App {

    @Override
    public void run() {
//        int[] nums1 = {1,4,3,6,4,3,7,2};
        int[] nums1 = {4,-2,-3,4,1};
        int res = sumSubarrayMins(nums1);
        System.out.println(res);
    }

    public int sumSubarrayMins(int[] arr) {
//        return twoStackApproach(arr);
        return betterApproach(arr);
    }

    /*
    3 1 2 5 2
    . -> 0
    3 -> 3       => 3
    31 -> 31  1  =>  1 1
    312 -> 312 12 2 => 1 1 2
    3125 -> 3125 125 25 5 =>  1 1 2 5
    31252 -> 31252 1252 252 52 2 => 1 1 2 2 2


     */
    private int betterApproach(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ple = new int[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            while (!stack.isEmpty() && val <= arr[stack.peek()]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(ple));
        int[] res = new int[n];
        int ans = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            res[i] = (i - ple[i]) * arr[i];
            if (ple[i] != -1) res[i] += res[ple[i]];
            ans = (int) ((ans + res[i]) % mod);
        }
        System.out.println(Arrays.toString(res));
        return ans;
    }

    private int twoStackApproach(int[] arr) {
        int n = arr.length;
        int[] ple = getPLE(arr);
        int[] nle = getNLE(arr);
        // System.out.println(Arrays.toString(ple));
        // System.out.println(Arrays.toString(nle));
        int res = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            res = (int) ((res + (long) arr[i] * ple[i] * nle[i]) % mod);
        }
        return res;
    }

    private int[] getNLE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            while (!stack.isEmpty() && val < arr[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    private int[] getPLE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            while (!stack.isEmpty() && val <= arr[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return res;
    }
}
