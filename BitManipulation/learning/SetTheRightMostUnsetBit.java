package strivers.BitManipulation.learning;

import strivers.App;
import strivers.Main;

//https://www.codingninjas.com/studio/problems/set-the-rightmost-unset-bit_8160456
public class SetTheRightMostUnsetBit implements App {

    @Override
    public void run() {
        int num = 10;
        int res = setBits(num);
        System.out.println(res);
    }


    // x+1 can be written as => (i) flip all set bits after the least 0  bit
    // (ii) finally flip the that least 0  bit as well
    // for ex: 10100 => 20
    // (i) position of least 0 bit is 0 ->  10100
    // it will be 10101 -> now flip the 0 at first position into 1 hence it will be 10111
    public static int setBits(int N){
        if((N^N+1)==(N<<1)+1) return N;
        return (N | N+1);
    }
}
