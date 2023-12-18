package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/description/
public class AsteroidCollision implements App {

    @Override
    public void run() {
        int[] asteroids = {5, 10, -5};
        int[] res = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));

        asteroids = new int[]{8, -8};
        res = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));

        asteroids = new int[]{10, 2, -5};
        res = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }

    // 10 2 -5
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            int weight = asteroids[i];
            if (weight > 0) stack.push(weight);
            else {
                int curr = weight;
                while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
                    int top = stack.pop();
                    if (top == (curr * -1)) {
                        curr = 0;
                        break;
                    }
                    curr = (top < (curr * -1)) ? curr : top;
                }
                if (curr != 0) stack.push(curr);
            }
        }
        int[] res = new int[stack.size()];
        for (int i=stack.size()-1;i>=0;i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
