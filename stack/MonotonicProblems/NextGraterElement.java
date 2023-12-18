package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


//https://leetcode.com/problems/next-greater-element-i/
public class NextGraterElement implements App {

    @Override
    public void run() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums2.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=len-1;i>=0;i--) {
            int val = nums2[i];
            while (!stack.isEmpty() && val>= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peek());
            stack.push(val);
        }
        for(int i=0;i<nums1.length;i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
