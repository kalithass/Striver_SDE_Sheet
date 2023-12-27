package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum
public class CombinationSum implements App {

    @Override
    public void run() {
        int[] a = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(a, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        recursionHelper(candidates, target, n, new ArrayList<Integer>(), res);
        return res;
    }

    private void recursionHelper(int[] a, int target, int n, ArrayList<Integer> list, List<List<Integer>> res) {
        if(n==0) {
            if (target == 0) res.add(new ArrayList<>(list));
            return;
        }
        if (target - a[n-1] >= 0) {
            list.add(a[n-1]);
            recursionHelper(a, target-a[n-1], n, list, res);
            list.remove(list.size()-1);
        }
        recursionHelper(a, target, n-1, list, res);

        // if(sum > target) return;
        // if(target == sum) {
        //     res.add(new ArrayList<>(ds));
        //     return;
        // }

        // for(int i=n;i<a.length;i++) {
        //     if(a[i] <= target) {
        //        ds.add(a[i]);
        //        helper(a, sum+a[i], i, res, ds, target);
        //        ds.remove(ds.size()-1);
        //     }
        // }
        //  if (sum > target) {
        //     return;
        // }
    }
}
