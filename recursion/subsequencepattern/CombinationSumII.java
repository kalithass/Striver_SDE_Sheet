package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII implements App {

    @Override
    public void run() {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(a, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        List<List<Integer>> res = new ArrayList<>();
//        recursiveHelper(candidates, target, res, new ArrayList<>(), 0);
        recursiveHelper2(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void recursiveHelper2(int[] a, int target, List<List<Integer>> res, ArrayList<Integer> list, int start) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=start;i<a.length;i++) {
            if (i>start && a[i] == a[i-1]) continue;
            list.add(a[i]);
            recursiveHelper2(a, target-a[i], res, list, i+1);
            list.remove(list.size()-1);
        }
    }

    private void recursiveHelper(int[] a, int target, List<List<Integer>> res, ArrayList<Integer> list, int i) {
        if(i == a.length) {
            if (target == 0) res.add(new ArrayList<>(list));
            return;
        }

        if (target - a[i] >= 0) {
            list.add(a[i]);
            recursiveHelper(a, target-a[i], res, list, i+1);
            list.remove(list.size()-1);
        }

        i++;
        while (i<a.length && a[i] == a[i-1]) {
            i++;
        }

        recursiveHelper(a, target, res, list, i);
    }


}
