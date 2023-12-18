package strivers.BitManipulation.InterviewProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets implements App {

    @Override
    public void run() {
        int[] nums = {123};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        int combinations = (int) Math.pow(2, n);
        for(int i=0;i<combinations;i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i & (1<<j)) != 0) {
                    list.add(a[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
