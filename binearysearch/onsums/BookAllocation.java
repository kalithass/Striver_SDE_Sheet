package strivers.binearysearch.onsums;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.codingninjas.com/studio/problems/allocate-books_1090540
public class BookAllocation  implements App {

    @Override
    public void run() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,20,30,40));
        int n = 4;
        int m = 3;
        int res = findPages(arr, n, m);
        System.out.println(res);
    }

    // this is similar to ship allocation
    // day = students
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // high will be sum(arr), it is not possible to assign books more than present
        // return naiveApproach(arr, n, m);
        return optimalApproach(arr, n, m);
    }

    private static int optimalApproach(ArrayList<Integer> arr, int n, int m) {
        if(m > n) return -1;
        int low= 1;
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low+high)/2;
            if(!isPossibleToAssignBooksToMStudents(arr, m, mid)) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private static int naiveApproach(ArrayList<Integer> arr, int n, int m) {
        if(m > n) return -1;

        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for(int i=1;i<=high;i++) {
            if(isPossibleToAssignBooksToMStudents(arr, m, i)) return i;
        }

        // max of element will be assigned at least
        return -1;
    }

    private static boolean isPossibleToAssignBooksToMStudents(ArrayList<Integer> arr, int m, int minPages) {
        int studentsAssigned = 1;

        int currentPagesAssigned = 0;
        for(int element : arr) {
            // assign will not be contiguous
            if (element > minPages) return false;

            if (currentPagesAssigned+element > minPages) {
                studentsAssigned++;
                currentPagesAssigned = element;
                if (studentsAssigned > m) return false;
            } else {
                currentPagesAssigned += element;
            }
        }
        return true;
    }
}
