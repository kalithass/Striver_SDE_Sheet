package strivers.BitManipulation.learning;

import strivers.App;

//https://www.codingninjas.com/studio/problems/swap-two-numbers_1380853
public class SwapNumber implements App {

    @Override
    public void run() {
        int[] a = {6};
        int[] b = {8};
        System.out.println("Before: "+a[0] +" "+b[0]);
        swapNumber(a, b);
        System.out.println("After: "+a[0] +" "+b[0]);
    }

    public static void swapNumber(int []a, int []b) {
        a[0] = a[0]^b[0];
        b[0] = a[0]^b[0];
        a[0] = a[0]^b[0];
    }
}
