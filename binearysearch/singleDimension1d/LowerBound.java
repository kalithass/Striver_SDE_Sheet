package strivers.binearysearch.singleDimension1d;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/lower-bound_8165382
public class LowerBound implements App {

    @Override
    public void run() {
        int[] arr = {1,2,2,3,4,5};
        int res = lowerBound(arr, arr.length, 2);
        System.out.println(res);
    }

    // index of first element which is greater than or equal to x
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0, high= n-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] >= x) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
