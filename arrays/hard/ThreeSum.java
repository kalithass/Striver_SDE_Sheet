package strivers.arrays.hard;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSum implements App {

    @Override
    public void run() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
//        return betterApproach(nums);
        return optimalApproach(nums);
    }

    private List<List<Integer>> optimalApproach(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            int sum = nums[i];
            while (j<k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) j++;
                else if(sum > 0) k--;
                else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) j++;
                    while (j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return res;
    }

    private static ArrayList<List<Integer>> betterApproach(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> temp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (set.contains(-sum)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-sum);
                    Collections.sort(list);
                    temp.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(temp);
    }
}
