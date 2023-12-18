package strivers.greedy.aryanPlaylist.hard;

import strivers.App;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/minimum-time-to-complete-all-tasks/
public class MinTimeToCompleteAllTasks implements App {

    @Override
    public void run() {
        int[][] tasks = {{2, 3, 1}, {4, 5, 1}, {1, 5, 2}};
        int res = findMinimumTime(tasks);
        System.out.println(res);
    }

    // 2 3 1
    // 4 5 1
    // 1 5 2
    public int findMinimumTime(int[][] tasks) {
        // sort by end time ascending order
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));

//        boolean[] arr = new boolean[2001];

        boolean[] arr = new boolean[6];

        int ind = 0;
        for(int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int duration = task[2];
            for(int i=start;i<=end;i++) {
                if(arr[i]) duration--;
            }


            for(int i=end;duration>0;i--) {
//                if(arr[i]) continue;
//                duration--;
//                arr[i] = true;

                if(!arr[i]) {
                    duration--;
                    arr[i] = true;
                }
            }
        }

        int res = 0;
        for(boolean bool : arr) {
            if(bool) res++;
        }
        return res;
    }
}
