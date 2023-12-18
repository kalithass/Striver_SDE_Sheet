package strivers.stack.learning;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        int min;
        if(st.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, st.peek().minSoFar);
        }
        st.push(new Pair(val, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().minSoFar;
    }

    static class Pair {
        int val;
        int minSoFar;

        Pair(int val, int minSoFar) {
            this.val = val;
            this.minSoFar = minSoFar;
        }
    }
}
