package strivers.dp.dpOnLIS;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LISUsingBinarySearch implements App {

    @Override
    public void run() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
        return binarySearchApproach(nums);
    }

    /*
            {1,2,7,5,4,10}
            i = 0, [1]
            i = 1, [1,2]
            i = 2, [1,2,7]
            i = 3, [1,2,7] [1,2,5]
            i = 4, [1,2,7] [1,2,5] [1,2,4]
            i = 5, [1,2,7,10] [1,2,5,10] [1,2,4,10]

            In above sequence each time if we encounter the last element from the end of subsets
            we are creating new subset.

            If we look closely we can directly insert the small element inside the single set rather than creating new set
            it will ensure that the length is maximum but the set will not be the actual subset
            for ex: 
            {1,2,7,5,4,10}
            i = 0, [1]
            i = 1, [1,2]
            i = 2, [1,2,7]
            i = 3, [1,2,5]
            i = 4, [1,2,4]
            i = 5, [1,2,4,10]
         */
    private int binarySearchApproach(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i=1;i<nums.length;i++) {
            int element = nums[i];
            if (element > list.get(list.size()-1)) list.add(element);
            else {
                int ind = lowerBound(list, element);
                list.set(ind, element);
            }
        }
        return list.size();
    }

    private int lowerBound(List<Integer> list, int num) {
        int low = 0, high = list.size()-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (list.get(mid) >= num) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
