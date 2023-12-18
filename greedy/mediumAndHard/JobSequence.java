package strivers.greedy.mediumAndHard;


import strivers.App;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
public class JobSequence implements App {

    @Override
    public void run() {
        int[][] jobs = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
        int n = jobs.length;

        Job[] arr = new Job[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(jobs[i][0], jobs[i][1], jobs[i][2]);
        }
        int[] res = JobScheduling(arr, n);
        System.out.println(Arrays.toString(res));
    }

    int[] JobScheduling(Job[] arr, int n) {
        return jobScheduling(arr, n);
    }

    private int[] jobScheduling(Job[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) max = Math.max(arr[i].deadline, max);

        Arrays.sort(arr, (e1, e2) -> e2.profit - e1.profit);

        int[] schedule = new int[max + 1];
        for(int i=0;i<max+1;i++) {
            schedule[i] = -1;
        }

        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            int deadLine = arr[i].deadline;
            int profit = arr[i].profit;
            int j = deadLine;
            while (j>=1 && schedule[j] != -1) {
                j--;
            }
            if(j <1 ) continue;
            schedule[j] = arr[i].id;
            res[0]++;
            res[1] += arr[i].profit;
        }

//        System.out.println(Arrays.toString(schedule));
        return res;
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}