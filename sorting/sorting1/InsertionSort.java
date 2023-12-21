package strivers.sorting.sorting1;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/description/
public class InsertionSort implements App {

    @Override
    public void run() {
        int[] arr = {6,5,3,2,8,10,9};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private void insertionSort(int[] arr, int n) {
        for(int i=1;i<n;i++) {
            int val = arr[i];

            int j = i-1;
            while (j>=0 && arr[j] > val) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }


}
