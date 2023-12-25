package strivers.binearysearch.singleDimension1d;

import strivers.App;

//https://leetcode.com/problems/single-element-in-a-sorted-array
public class SingleElementInSortedArray implements App {

    @Override
    public void run() {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int res = singleNonDuplicate(arr);
        System.out.println(res);
    }

    public int singleNonDuplicate(int[] a) {
        int n = a.length;
        int low = 1, high = n - 2;
        if (n == 1) return a[0];
        if (a[0] != a[1]) return a[0];
        if (a[n - 1] != a[n - 2]) return a[n - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] != a[mid - 1] && a[mid] != a[mid + 1]) {
                return a[mid];
            }
            if ((mid % 2 == 0 && a[mid - 1] == a[mid]) || (mid % 2 == 1 && a[mid + 1] == a[mid])) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
