package strivers.greedy.mediumAndHard;

import strivers.App;

import java.util.Arrays;


//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
public class MinimumPlatforms implements App {

    @Override
    public void run() {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        int n = arr.length;
        int res = findPlatform(arr, dep, n);
        System.out.println(res);
    }

    static int findPlatform(int arr[], int dep[], int n) {
//        return tempApproach(arr, dep, n);
        return greedyApproach(arr, dep, n);
    }

    static int greedyApproach(int[] arr, int[] dep, int n)
    {
        Time[] times = new Time[2 * n];
        for (int i = 0; i < n; i++) {
            times[i] = getFormattedTime(arr[i], 1);
            times[i + n] = getFormattedTime(dep[i], -1);
        }
        Arrays.sort(times, (e1, e2) -> {
            if (e1.time == e2.time) {
                return e2.indicator - e1.indicator;
            }
            return e1.time - e2.time;
        });

        int res = 1;
        int curr = 0;

        for (int i = 0; i < 2*n; i++) {
            curr += times[i].indicator;
            res = Math.max(res, curr);
        }

        // System.out.println(Arrays.toString(times));
        return res;
    }

    private static Time getFormattedTime(int val, int indicator) {
        return new Time(val, indicator);
    }

    static class StayDuration {
        Time arrival;
        Time departure;

        public StayDuration(Time arrival, Time departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        @Override
        public String toString() {
            return "[" +
                    arrival + " , " +
                    departure +
                    ']';
        }
    }

    static class Time {
        int time;
        int indicator;

        public Time(int time, int indicator) {
            this.time = time;
            this.indicator = indicator;
        }

        @Override
        public String toString() {
            return "(" + time + ", " + indicator + ")";
        }
    }
}
