package strivers.binearysearch.onsums;

import strivers.App;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/kth-missing-positive-number/
public class FindKthMissingNumber implements App {

    @Override
    public void run() {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        int res = findKthPositive(arr, k);
        System.out.println(res);
    }

    public int findKthPositive(int[] arr, int k) {
//        return naiveApproach(arr, k);
//        return betterApproach(arr, k);
        return optimalApproach(arr, k);
    }

    private int optimalApproach(int[] arr, int k) {
        /*
             2 3 4 5 6 8 11 15
             2 2 2 2 2 3 5  8  => a[i] - i

             diff = a[i] - i
             res = index of diff which is smaller or equal to k

             k = 7
             x = k - diff + a[res] + 1 => 7 - 5 +11 + 1-> 14

             k = 5,
             x =  k - diff + a[res] + 1 => 5 - 5 + 11 + 1 => 12

             k = 8
             x = k - diff + a[res] + 1 => 8 - 8 + 15 + 1 => 16

             k = 9
             x = k - diff + a[res] + 1 => 9 - 8 + 15 + 1 => 17



             1 7 9 10 12 13 14 16  17
             1 2 3 4   5  6  7  8  9

         */

        if(arr[0] > k) return k;
        int n = arr.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = (low+high)/2;
            int diff = arr[mid] - mid;
            if(diff <= k) low = mid+1;
            else high = mid-1;
        }
        int diff = arr[high] - high;
        return k - diff + arr[high] + 1;
    }

    private int betterApproach(int[] arr, int k) {
        int index = 0;
        int n = arr.length;

        int nthMissingNumber = 0;
        for(int i=1;i<arr[n-1];i++) {
            if(arr[index] == i) index++;
            else {
                nthMissingNumber++;
                if (nthMissingNumber == k) return i;
            }
        }

        // 1 2 3 5  -> k = 4, nthMissingNumber = 1, so kth missingNumber will be (5 + k - nthMissingNumber)
        return arr[n-1] - nthMissingNumber + k;
    }

    private static int naiveApproach(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int element : arr) set.add(element);

        int missingIndex = 0;
        int i=1;
        while (true) {
            if (!set.contains(i)) missingIndex++;
            if (missingIndex == k) return i;
            i++;
        }
    }
}
