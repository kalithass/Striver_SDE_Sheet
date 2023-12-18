package strivers.heap.medium;

import strivers.App;
import strivers.Main;

import java.util.*;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler implements App {

    @Override
    public void run() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int res = leastInterval(tasks, 2);
        System.out.println(res);
    }

    public int leastInterval(char[] tasks, int n) {
        return usingGreedyApproach(tasks, n);
//        return usingPriorityQueue(tasks, n);
    }

    private int usingGreedyApproach(char[] tasks, int n) {
        int[] values = new int[26];
        for(int element : tasks) {
            values[element-'A']++;
        }
        Arrays.sort(values);
        // A__A__A -> if A is 3 we have 2 idle groups
        int idleGroupCount = values[25]-1;

        // A__A__A__A -> idle group is 3 and n is 2, hence idle spots are 6 (s underscores)
        int idleSpots = idleGroupCount * n;

        for(int i=24;i>=0;i--) {
            if(values[i] == 0) break;
            // AAABBB -> 3A 3B
            // A__A__A -> Here we have 3 B, but we have only 2 idle groups.
            // So we need the min of idleGroup of variable count and idle group
            idleSpots -= Math.min(values[i], idleGroupCount);
        }

        // finally return the tasks with idle spots
        // if idle spots went to negative value, make it as 0
        return tasks.length + Math.max(0, idleSpots);
    }

    private static int usingPriorityQueue(char[] tasks, int n) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char element : tasks) {
            hm.put(element, hm.getOrDefault(element, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(hm.values());
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll() - 1;
                if (val > 0) queue.add(new Pair(time + n, val));
            }
            if (!queue.isEmpty() && queue.peek().time == time) {
                pq.add(queue.poll().val);
            }
        }
        return time;
    }

    static class Pair {
        int time;
        int val;

        public Pair(int time, int val) {
            this.time = time;
            this.val = val;
        }
    }
}
