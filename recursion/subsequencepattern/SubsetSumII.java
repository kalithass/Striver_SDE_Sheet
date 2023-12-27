package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class SubsetSumII implements App {

    @Override
    public void run() {
        int[] a = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(a);
        System.out.println(res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
//        recursiveHelper(res, nums, 0, new ArrayList<>());
        recursiveHelper2(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void recursiveHelper2(List<List<Integer>> res, int[] nums, int start, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i=start;i<nums.length;i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            recursiveHelper2(res, nums, i+1, list);
            list.remove(list.size()-1);
        }
    }

    private void recursiveHelper(List<List<Integer>> res, int[] nums, int i, ArrayList<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        recursiveHelper(res, nums, i+1, list);
        list.remove(list.size()-1);

        i++;
        while (i<nums.length && nums[i] == nums[i-1]) i++;
        recursiveHelper(res, nums, i, list);
    }
}
