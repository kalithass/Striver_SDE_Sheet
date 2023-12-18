package strivers.greedy.aryanPlaylist.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/largest-submatrix-with-rearrangements/
public class LargestSubMatrixWithRearrangements implements App {

    @Override
    public void run() {
//        int[][] mat = {
//                {0, 1, 0},
//                {1, 0, 0},
//                {1, 0, 0}
//        };
        int[][] mat = {{1,0,1,0,1}};
        int res = largestSubmatrix(mat);
        System.out.println(res);
    }

    public int largestSubmatrix(int[][] matrix) {
//        return usingSortAndReverse(matrix);
        return withoutSorting(matrix);
    }

    private int withoutSorting(int[][] matrix) {
        int res = 0;
        List<Pair> prevList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int n = matrix[i].length;
            boolean[] seen = new boolean[n];
            List<Pair> list = new ArrayList<>();

            for(Pair pair : prevList) {
                if(matrix[i][pair.ind] !=0 ) {
                    list.add(new Pair(pair.val+1, pair.ind));
                    seen[pair.ind] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != 0 && !seen[j]) {
                    list.add(new Pair(1, j));
                    seen[j] = true;
                }
            }

            prevList = list;
        }
        int i=0;
        for(Pair pair : prevList) {
            res = Math.max(res, pair.val * (i+1));
            i++;
        }

        return res;
    }

    class Pair {
        int val;
        int ind;

        Pair(int val, int ind) {
            this.ind = ind;
            this.val = val;
        }
    }

    private int usingSortAndReverse(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int n = matrix[i].length;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    arr[j] += matrix[i][j];
                    if(i > 0) arr[j] += matrix[i-1][j];
                }
                matrix[i][j] = arr[j];
            }
            Arrays.sort(arr);
            reverse(arr);
//            System.out.println(Arrays.toString(arr));
            for (int j = 0; j < n; j++) {
                res = Math.max(res, arr[j] * (j + 1));
            }
        }
        return res;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
