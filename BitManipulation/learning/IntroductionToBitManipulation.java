package strivers.BitManipulation.learning;
import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/bit-manipulation_8142533
public class IntroductionToBitManipulation  implements App {

    @Override
    public void run() {
        int num = 25;
        int i = 3;
        int[] res = bitManipulation(num, i);
        System.out.println(Arrays.toString(res));
    }

    public static int[] bitManipulation(int num, int i){
        --i;

        int[] res = new int[3];
        res[0] = (num >> i) & 1;
        res[1] = num | (1<<i);
        res[2] = num & (~(1<<i));
        return res;
    }
}
