package strivers.arrays.easy;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960
public class SecondLargestAndSmallest implements App {

    @Override
    public void run() {
        int[] arr = {3, 4, 5, 2};
        int[] res = getSecondOrderElements(arr.length, arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getSecondOrderElements(int n, int[] a) {
        int[] res = new int[2];
        res[0] = getSecondLargestElement(a);
        res[1] = getSecondSmallestElement(a);
        return res;
    }

    private static int getSecondSmallestElement(int[] a) {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for(int element : a) {
            if(element < small) {
                secondSmall = small;
                small = element;
            } else if(element < secondSmall && small != element) {
                secondSmall = element;
            }
        }
        return secondSmall;
    }

    private static int getSecondLargestElement(int[] a) {
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for(int element : a) {
            if(element > large) {
                secondLarge = large;
                large = element;
            } else if(element > secondLarge && large != element) {
                secondLarge = element;
            }
        }
        return secondLarge;
    }
}
