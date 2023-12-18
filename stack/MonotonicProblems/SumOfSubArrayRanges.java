package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubArrayRanges implements App {

    @Override
    public void run() {
        int[] nums = {4,-2,-3,4,1};
        long res = subArrayRanges(nums);
        System.out.println(res);
    }


    // for a particular sub array it is max-min
    // for n sub arrays it will be (maxi-mini) + (maxj-minj)....
    // rewrite them as (maxi+maxj+...) - (mini+minj+..)
    // hence (sum of max elements in each sub arrays) - (sum of min elements in each)
    public long subArrayRanges(int[] nums) {
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        int n = nums.length;
        int[] minRange = new int[n];
        int[] maxRange = new int[n];

        for(int i=0;i<n;i++) {
            while (!minStack.isEmpty() && nums[i]<=nums[minStack.peek()]) {
                minStack.pop();
            }

            while (!maxStack.isEmpty() && nums[i]>=nums[maxStack.peek()]) {
                maxStack.pop();
            }
            minRange[i] = minStack.isEmpty() ? -1 : minStack.peek();
            maxRange[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            minStack.push(i);
            maxStack.push(i);
        }

        long ans = 0;

        long[] minRes = new long[n];
        long[] maxRes = new long[n];

        for(int i=0;i<n;i++) {
            // calculate min sum
            minRes[i] = (long) (i - minRange[i]) * nums[i];
            if(minRange[i] != -1) {
                minRes[i] += minRes[minRange[i]];
            }

            // calculate max sum
            maxRes[i] = (long) (i - maxRange[i]) * nums[i];
            if(maxRange[i] != -1) {
                maxRes[i] += maxRes[maxRange[i]];
            }
            ans += maxRes[i] - minRes[i];
        }
        System.out.println(Arrays.toString(maxRange));
        System.out.println(Arrays.toString(maxRes));

        System.out.println();
        System.out.println(Arrays.toString(minRange));
        System.out.println(Arrays.toString(minRes));
        return ans;
    }
}

/*
        [-1, -1, -1, 2, 2]
        [4, -4, -9, -5, -7]
        -21
 */
