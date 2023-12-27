package strivers.recursion.getastronghold;

import strivers.App;

import java.util.Stack;

//https://www.codingninjas.com/studio/problems/reverse-stack-using-recursion_631875
public class ReverseTheStack implements App {

    @Override
    public void run() {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(-2);
        st.push(9);
        st.push(-7);
        st.push(3);
        reverseStack(st);
        System.out.println(st);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverseStack(stack);
            insertAtTheBottom(stack, temp);
        }
    }

    private static void insertAtTheBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertAtTheBottom(stack, element);
        stack.push(temp);
    }
}
