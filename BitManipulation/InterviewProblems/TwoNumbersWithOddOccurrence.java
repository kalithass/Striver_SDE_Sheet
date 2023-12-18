package strivers.BitManipulation.InterviewProblems;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/two-numbers-with-odd-occurrences_8160466
public class TwoNumbersWithOddOccurrence implements App {

    @Override
    public void run() {
        int[] arr = {3, 3, 1, 2};
        int[] res = twoOddNum(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoOddNum(int[] arr) {
        int val = 0;
        for(int element : arr) val ^= element;

        int count = (val & ~(val - 1));

        // while (val > 0) {
        //     if(val %2 == 1) break;
        //     val = val/2;
        //     count++;
        // }

        int x = 0;
        int y = 0;

        for(int element : arr) {
            if((element & count) == 0) {
                x = x^element;
            } else {
                y = y^element;
            }
        }

        // for(int element : arr) {
        //     if((element & (1<<count)) == 0) {
        //         x = x^element;
        //     } else {
        //         y = y^element;
        //     }
        // }
        if(x>y) return new int[]{x,y};
        return new int[]{y,x};
    }
}
