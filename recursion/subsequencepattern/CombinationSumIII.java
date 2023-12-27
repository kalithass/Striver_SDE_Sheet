package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII implements App {

    @Override
    public void run() {
        int k = 3;
        int n = 7;
        List<List<Integer>> res = combinationSum3(k, n);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        recursiveHelper2(1,  k, n, res, ds);
        return res;
    }

    private void recursiveHelper2(int ind, int k, int n, List<List<Integer>> res, List<Integer> ds) {
        if(n == 0 && ds.size()==k) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<=9;i++) {
            ds.add(i);
            recursiveHelper2(i+1, k, n-i, res, ds);
            ds.remove(ds.size() - 1);
        }
    }

    private void recursiveHelper(int element, int k, int target, List<List<Integer>> res, List<Integer> ds) {
        if(target<0) return;
        if(element == 10) {
            if(target == 0 && ds.size() == k) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(element);
        recursiveHelper(element+1,  k, target-element, res, ds);
        ds.remove(ds.size()-1);
        recursiveHelper(element+1,  k, target, res, ds);
    }
}
