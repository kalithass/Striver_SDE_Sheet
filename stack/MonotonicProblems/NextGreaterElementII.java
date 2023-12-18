package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii
public class NextGreaterElementII  implements App {

    @Override
    public void run() {
        int[] nums = {1, 2, 1};
//        int[] nums = {1, 2, 3, 4, 3};
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--) {
            // System.out.println(stack);
            while (!stack.isEmpty() && nums[i%n] >= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()) res[i%n] = -1;
            else res[i%n] = stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
