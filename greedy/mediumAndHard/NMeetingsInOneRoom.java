package strivers.greedy.mediumAndHard;

import strivers.App;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
public class NMeetingsInOneRoom implements App {

    @Override
    public void run() {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;
        int res = maxMeetings(start, end, n);
        System.out.println(res);
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(e -> e.end));

        int res = 1;
        int currEnd = arr[0].end;
        for (int i = 1; i < n; i++) {
            if(arr[i].start > currEnd) {
                res++;
                currEnd = arr[i].end;
            }
        }
        return res;
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
