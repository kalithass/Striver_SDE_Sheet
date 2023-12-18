package strivers.BitManipulation.learning;

import strivers.App;

//https://www.codingninjas.com/studio/problems/power-of-two_893061
public class CheckNumberIsPowerOf2 implements App {

    @Override
    public void run() {
        int num = 35;
        boolean res = isPowerOfTwo(num);
        System.out.println(res);
    }


    public static boolean isPowerOfTwo(int n) {
//        int count = 0;
//        for(int i=0;i<32;i++) {
//            if((n & 1) == 1) {
//                count++;
//                if(count >1) return false;
//            }
//            n = n>>1;
//        }
//        return true;
        if (n <= 0) return false;
        return ((n & (n - 1)) == 0);
    }
}
