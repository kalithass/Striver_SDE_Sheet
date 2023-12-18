package strivers.greedy.mediumAndHard;


import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals implements App {

    @Override
    public void run() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        printArr(res);
    }

    public int[][] merge(int[][] a) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));

        int start = a[0][0];
        int end = a[0][1];

        for(int i=1;i<a.length;i++) {
            if(end >= a[i][0]) end = Math.max(end, a[i][1]);
            else {
                res.add(new int[]{start, end});
                start = a[i][0];
                end = a[i][1];
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }

    private static void printArr(int[][] res) {
        for (int[] arr : res) System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}
