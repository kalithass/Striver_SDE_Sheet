package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater implements App {

    @Override
    public void run() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap(height);
        System.out.println(res);
    }

    public int trap(int[] height) {
        return optimizedTrapRainWater(height);
//        return trapRainWater(height);
    }

    private int optimizedTrapRainWater(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, leftMax = height[left], rightMax = height[right];
        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        return res;
    }

    private int trapRainWater(int[] height) {
        int[] maxLeft = getMaxLeftArray(height);
        int[] maxRight = getMaxRightArray(height);
        int res = 0;
        for(int i = 0; i< height.length; i++) {
            int val = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(val > 0 ) {
                res += val;
            }
        }
        return res;
    }

    private int[] getMaxRightArray(int[] height) {
        int maxSoFar = 0;
        int[] res = new int[height.length];
        for(int i=height.length-1;i>=0;i--) {
            if(height[i] > maxSoFar) {
                maxSoFar = height[i];
            }
            res[i] = maxSoFar;
        }
        return res;
    }

    int[] getMaxLeftArray(int[] height) {
        int maxSoFar = 0;
        int[] res = new int[height.length];
        for(int i=0;i<height.length;i++) {
            if(height[i] > maxSoFar) {
                maxSoFar = height[i];
            }
            res[i] = maxSoFar;
        }
        return res;
    }
}
