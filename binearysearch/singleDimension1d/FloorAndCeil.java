package strivers.binearysearch.singleDimension1d;

import strivers.App;

//https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401
public class FloorAndCeil implements App {

    @Override
    public void run() {
        int[] arr = {3,4,7,8,8,10};
        int[] res = getFloorAndCeil(arr, arr.length, 4);
        System.out.println(res[0]+" "+res[1]);
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int[] res = new int[2];
        res[0] = getFloor(a, n, x);
        res[1] = getCeil(a,n,x);
        return res;
    }

    private static int getCeil(int[] a, int n, int x) {
        int low = 0, high = n-1;
        while (low<=high) {
            int mid =(low+high)/2;
            if(a[mid]>= x) high = mid-1;
            else low = mid+1;
        }
        if(low == -1 || low == n) return -1;
        return a[low];
    }

    private static int getFloor(int[] a, int n, int x) {
        int low = 0, high = n-1;
        while (low<=high) {
            int mid =(low+high)/2;
            if(a[mid]<= x) low = mid+1;
            else high = mid-1;
        }
        if(high == -1 || high == n) return -1;
        return a[high];
    }
}
