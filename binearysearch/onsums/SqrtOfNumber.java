package strivers.binearysearch.onsums;

import strivers.App;

//https://www.codingninjas.com/studio/problems/square-root-integral_893351
public class SqrtOfNumber implements App {

    @Override
    public void run() {
        int res = sqrtN(130);
        System.out.println(res);
    }


    public static int sqrtN(long n) {
        long low = 0, high = n;
        while (low<=high) {
            long mid = (low+high)/2;
            if(mid*mid > n) high = mid-1;
            else low = mid+1;
        }
        return (int) high;
    }
}
