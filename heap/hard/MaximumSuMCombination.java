package strivers.heap.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://www.interviewbit.com/problems/maximum-sum-combinations/
public class MaximumSuMCombination implements App {

    @Override
    public void run() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 5, 1, 6));
        int C = 4;
        ArrayList<Integer> res = solve(A, B, C);
        System.out.println(res);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(A);
        Collections.reverse(B);
        for (int a : A) {
            for (int b : B) {
                int sum = a+b;
                if(pq.size()==C && sum < pq.peek()) break;
                pq.add(sum);
                if (pq.size() > C) pq.poll();
            }
        }
        while (!pq.isEmpty()) res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }
}
