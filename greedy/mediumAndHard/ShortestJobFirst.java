package strivers.greedy.mediumAndHard;

import strivers.App;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.codingninjas.com/studio/problems/sjf_1172165
public class ShortestJobFirst implements App {

    @Override
    public void run() {
        int[] arrivalTime = {12, 29, 25, 22, 4, 24, 29, 10, 11};
        int[] burstTime = {26, 11, 14, 3, 21, 6, 28, 29, 7};
//        int[] arrivalTime = {4, 10};
//        int[] burstTime = {5, 1};
        int n = arrivalTime.length;
        float res = sjf(n, arrivalTime, burstTime);
        System.out.println(res);
    }


    public static float sjf(int n, int []arrivalTime, int []burstTime)
    {
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(arrivalTime[i], burstTime[i]);
        }
        Arrays.sort(jobs, (a,b) -> {
            if(a.arrivalTime==b.arrivalTime) {
                return a.burstTime-b.burstTime;
            }
            return a.arrivalTime-b.arrivalTime;
        });
        Queue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.burstTime));
        pq.offer(jobs[0]);

        int waitTime = 0;
        int cpuTime = jobs[0].arrivalTime;
        int i=1;
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            cpuTime = Math.max(cpuTime, job.arrivalTime);
            waitTime += cpuTime - job.arrivalTime;
            cpuTime = cpuTime + job.burstTime;

            while (i<n && jobs[i].arrivalTime <= cpuTime) {
                pq.offer(jobs[i]);
                i++;
            }
            if(pq.isEmpty() && i<n) {
                pq.offer(jobs[i]);
                i++;
            }
        }
        return (float) waitTime / n;
    }

    static class Job {
        int arrivalTime;
        int burstTime;

        Job(int arrivalTime, int burstTime) {
            this.arrivalTime=arrivalTime;
            this.burstTime=burstTime;
        }
    }


}
