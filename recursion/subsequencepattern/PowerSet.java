package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class PowerSet implements App {

    @Override
    public void run() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
//        return iterativeApproach(nums);
        return recursiveApproach(nums);
    }

    private List<List<Integer>> recursiveApproach(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursiveHelper(res, nums, nums.length, new ArrayList<>());
        return res;
    }

    private void recursiveHelper(List<List<Integer>> res, int[] nums, int n, ArrayList<Integer> list) {
        if(n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        recursiveHelper(res, nums, n-1, list);
        list.add(nums[n-1]);
        recursiveHelper(res, nums, n-1, list);
        list.remove(list.size()-1);
    }

    private List<List<Integer>> iterativeApproach(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int count = 1 << n;
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ( (i & (1 << j)) != 0 ) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
