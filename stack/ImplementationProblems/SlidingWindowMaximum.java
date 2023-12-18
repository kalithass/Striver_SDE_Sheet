package strivers.stack.ImplementationProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum implements App {

    @Override
    public void run() {
        int[] heights = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(heights, k);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> deQue = new LinkedList<>();

        int max = 0;
        for(int i=0;i<k;i++) {
            if(nums[i] > nums[max]) {
                max = i;
            }
        }

        deQue.addLast(max);
        res[0] = nums[max];

        for(int i=0;i<n;i++) {
            while (!deQue.isEmpty() && deQue.peekFirst() < i-k+1) {
                deQue.pollFirst();
            }

            while (!deQue.isEmpty() && nums[i] >= nums[deQue.peekLast()]) {
                deQue.pollLast();
            }
            deQue.addLast(i);
            // System.out.println(deQue+" "+i);
            if(i>=k-1) res[i-k+1] = nums[deQue.peekFirst()];
        }
        return res;
    }
}
