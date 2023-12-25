package strivers.binearysearch.on2dArrays;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/row-of-a-matrix-with-maximum-ones_982768
public class RowWithMaxOnes implements App {

    @Override
    public void run() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int res = maximumOnesRow(matrix, matrix.get(0).size(), matrix.size());
        System.out.println(res);
    }

    // rows are sorted
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int max = 0;
        int resIndex = 0;
        for (int i = 0; i < n; i++) {
            int indexOfOne = getNumberOfOnes(matrix.get(i));
            int len = m - indexOfOne;
            if (len > max) {
                resIndex = i;
                max = len;
            }
        }
        return resIndex;
    }

    private static int getNumberOfOnes(ArrayList<Integer> list) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
