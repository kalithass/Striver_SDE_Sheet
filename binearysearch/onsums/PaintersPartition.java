package strivers.binearysearch.onsums;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557
public class PaintersPartition implements App {

    @Override
    public void run() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,20,30,40));
        int k = 2;
        int res = findLargestMinDistance(arr, k);
        System.out.println(res);
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {

        return naiveApproach(boards,boards.size(), k);
        // return optimalApproach(boards,boards.size(), k);
    }

    private static int optimalApproach(ArrayList<Integer> arr, int n, int m) {
        if(m > n) return -1;
        int low= 1;
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low+high)/2;
            if(!isPossibleToPaintAllBoards(arr, m, mid)) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private static int naiveApproach(ArrayList<Integer> arr, int n, int m) {
        if(m > n) return -1;

        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for(int i=1;i<=high;i++) {
            if(isPossibleToPaintAllBoards(arr, m, i)) return i;
        }

        // max of element will be assigned at least
        return -1;
    }

    private static boolean isPossibleToPaintAllBoards(ArrayList<Integer> arr, int m, int minPages) {
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
