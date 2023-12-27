package strivers.recursion.getastronghold;

import strivers.App;

import java.util.Stack;

//https://www.codingninjas.com/studio/problems/sort-stack_1229505
public class SortAStockUsingRecursion implements App {

    @Override
    public void run() {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(-2);
        st.push(9);
        st.push(-7);
        st.push(3);
        sortStack(st);
        System.out.println(st);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertInTheCorrectPlace(stack, temp);
        }
    }

    private static void insertInTheCorrectPlace(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        if(element > stack.peek()) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertInTheCorrectPlace(stack, element);
        stack.push(temp);
    }
}
