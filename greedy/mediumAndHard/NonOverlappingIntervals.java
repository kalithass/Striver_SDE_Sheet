package strivers.greedy.mediumAndHard;

import strivers.App;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals implements App {

    @Override
    public void run() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int res = eraseOverlapIntervals(intervals);
        System.out.println(res);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        int end   = intervals[0][1];

        for(int i=1;i<intervals.length;i++) {
            // current end is greater than next start
            if(end > intervals[i][0]) {
                res++;
                // we have removed the interval which is larger
                // so, we have to get the one which ends earlier
                end = Math.min(end, intervals[i][1]);
            }
            else {
                end = intervals[i][1];
            }
        }
        return res;
    }
}
