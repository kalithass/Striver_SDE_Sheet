package strivers.stack.ImplementationProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
public class StockSpanProblem implements App {

    @Override
    public void run() {
        int[] values = {100, 80, 60, 70, 60, 75, 85};
        int n = values.length;
        int[] res = new int[n];

        StockSpanner sb = new StockSpanner();
        for(int i=0;i<n;i++) {
            res[i] = sb.next(values[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}


class StockSpanner {

    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >= stack.peek().val) {
            count += stack.pop().count;
        }
        stack.push(new Pair(price, count));
        return count;
    }

    static class Pair {
        int val;
        int count;

        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}