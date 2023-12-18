package strivers.greedy.mediumAndHard;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertInterval implements App {

    @Override
    public void run() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] res = insert(intervals, newInterval);
        printArr(res);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        return withoutExtraArray(intervals, newInterval);
//        return withExtraArray(intervals, newInterval);
    }

    private int[][] withoutExtraArray(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int[] intervalToBeInserted = newInterval;

        //        tobe
        // [1,3] [2,5]
        // 1.
        //
        //
        for (int[] currentInterval : intervals) {
            // if new interval is completely left
            if(intervalToBeInserted[1] < currentInterval[0]) { // ? 5 < 1
                list.add(intervalToBeInserted);
                intervalToBeInserted = currentInterval;
            }
            // current interval is completely left
            else if(currentInterval[1] < newInterval[0]) { // ? 3 < 2
                list.add(currentInterval);
            }
            //
            else {
                intervalToBeInserted[0] = Math.min(intervalToBeInserted[0], currentInterval[0]);
                intervalToBeInserted[1] = Math.max(intervalToBeInserted[1], currentInterval[1]);
            }
        }
        list.add(intervalToBeInserted);
        return getArrayFromList(list);
    }

    private static int[][] withExtraArray(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        int n = intervals.length;
        int[][] arr = new int[n + 1][];
        int i = 0;
        for (; i < n; i++) {
            if (intervals[i][0] < newInterval[0]) arr[i] = intervals[i];
            else {
                arr[i] = newInterval;
                break;
            }
        }

        if (i == n) arr[i] = newInterval;
        while (i < n) {
            arr[i + 1] = intervals[i];
            i++;
        }

        printArr(arr);

        List<int[]> res = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for (i = 1; i <= n; i++) {
            int currStart = arr[i][0];
            int currEnd = arr[i][1];

            if (end >= currStart) end = Math.max(end, currEnd);
            else {
                res.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }

        res.add(new int[]{start, end});

        return getArrayFromList(res);
    }

    private static int[][] getArrayFromList(List<int[]> list) {
        return list.toArray(new int[list.size()][]);
    }

    private static void printArr(int[][] res) {
        for (int[] arr : res) System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}