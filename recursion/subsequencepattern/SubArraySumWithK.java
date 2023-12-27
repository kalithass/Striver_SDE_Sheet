package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/subarrays-with-sum-%E2%80%98k'_6922076
public class SubArraySumWithK implements App {

    @Override
    public void run() {
        int[] a = {1, 2, 3, 1, 1, 1};
        int k = 3;
        List<List<Integer>> listList = subarraysWithSumK(a, k);
        System.out.println(listList);
    }

    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
//        return naiveApproach(a, k);
        return optimalApproach(a, k);
    }

    private static List<List<Integer>> optimalApproach(int[] a, long k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        long sum = 0;
        int left = 0;
        List<Integer> list = new ArrayList<>();
        for (int right = 0; right < n; right++) {
            sum += a[right];
            list.add(a[right]);
            while (sum >= k && left <= right) {
                if (sum == k) res.add(new ArrayList<>(list));
                sum -= a[left];
                left++;
                list.remove(0);
            }
        }
        return res;
    }

    private static List<List<Integer>> naiveApproach(int[] a, long k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n; j++) {
                list.add(a[j]);
                sum += a[j];
                if (sum == k) {
                    res.add(new ArrayList<>(list));
                }
            }
        }
        return res;
    }
}
