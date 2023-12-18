package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.interviewbit.com/problems/nearest-smaller-element/
public class NextSmallerElement implements App {

    @Override
    public void run() {
//        int[] nums = {1, 2, 1};
//        int[] nums = {1, 2, 3, 4, 3};
        ArrayList<Integer> list =  new ArrayList<>();
        // 4 5 2 10 8
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(10);
        list.add(8);
        ArrayList<Integer> res = prevSmaller(list);
        System.out.println(res);
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i< list.size();i++) {
            int val = list.get(i);
            while (!stack.isEmpty() && val <= stack.peek()) {
                stack.pop();
            }
            int ans = stack.isEmpty() ? -1 : stack.peek();
            res.add(ans);
            stack.push(val);
        }
        return res;
    }
}
