package strivers.BitManipulation.InterviewProblems;

import strivers.App;

import java.util.List;

//https://www.codingninjas.com/studio/problems/l-to-r-xor_8160412
public class LtoRXor implements App {

    @Override
    public void run() {
        int L = 3;
        int R = 5;
        int res = findXOR(L, R);
        System.out.println(res);
    }

    public static int findXOR(int L, int R){
        return xOr1toN(R) ^ xOr1toN(L-1);
    }

    static int xOr1toN(int N) {
        if(N%4 == 0) return N;
        else if(N % 4 == 1) return 1;
        else if(N % 4 == 2) return N+1;
        else return 0;
    }
}


/*

000 0  000 0    N%4 = 0  => n
001 1  001 01   N%4 = 1  => 1
010 2  011 012  N%4 = 2  => n+1
011 3  000 0123 N%4 = 3 => 0

100 4  100 4     N%4 = 0 => n
101 5  001 45    N%4 = 1 => 1
110 6  111 456   N%4 = 2 => n+1
111 7  000 4567  N%4 = 3 => 0


 */