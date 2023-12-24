package strivers.arrays.medium;

import strivers.App;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.codingninjas.com/studio/problems/longest-successive-elements_6811740
public class LongestSuccessiveElements implements App {

    @Override
    public void run() {
        int[] a = {5, 8, 3, 2, 1, 4};
        int res = longestSuccessiveElements(a);
        System.out.println(res);
    }

    public static int longestSuccessiveElements(int[] a) {
//        return naiveApproach(a);
//        return betterApproach(a);
        return optimalApproach(a);
    }

    private static int optimalApproach(int[] a) {
        Set<Integer> set = new HashSet<>();
        for(int element : a) set.add(element);
        int res = 1;
        for (int element : a) {
            // ensures that we are checking from the starting sequence
            if(!set.contains(element-1)) {
                int count = 0;
                while (set.contains(element)) {
                    count++;
                    element++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    private static int betterApproach(int[] a) {
        Arrays.sort(a);
        int res = 1;
        int n = a.length;
        int count = 1;
        int current = a[0];
        for (int i = 1; i < n; i++) {
            // array may contain duplicate elements
            if(a[i] == current) continue;
            if (a[i] == current + 1) {
                count++;
                current++;
                res = Math.max(res, count);
            } else {
                current = a[i];
                count = 1;
            }
        }
        return Math.max(res, count);
    }

    private static int naiveApproach(int[] a) {
        int res = 1;
        for (int element : a) {
            int current = 1;
            int search = element + 1;
            while (isPresent(a, search)) {
                current++;
                search++;
            }
            res = Math.max(res, current);
        }
        return res;
    }

    private static boolean isPresent(int[] a, int val) {
        for (int element : a) {
            if (val == element) return true;
        }
        return false;
    }
}
