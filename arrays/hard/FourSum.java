package strivers.arrays.hard;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/4sum/
public class FourSum implements App {

    @Override
    public void run() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        return betterApproach(nums, target);
        // return optimalApproach(nums, target);
    }

    private List<List<Integer>> optimalApproach(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum > target) l--;
                    else if (sum < target) k++;
                    else {
                        res.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k<l && nums[k] == nums[k-1]) k++;
                        while (k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return res;
    }

    private List<List<Integer>> betterApproach(int[] nums, int target) {
        Set<List<Integer>> temp = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    if (set.contains(target - sum)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)(target - sum));
                        Collections.sort(list);
                        temp.add(list);
                    }
                    set.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(temp);
    }
}
