package strivers.sorting.sorting1;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/description/
public class SelectionSort implements App {

    @Override
    public void run() {
        int[] arr = {6,5,3,2,8,10,9};
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private void selectionSort(int[] arr, int n) {
        for(int i=0;i<n;i++) {
            int minPosition = i;
            for(int j=i+1;j<n;j++) {
                if(arr[j] < arr[minPosition] ) minPosition = j;
            }
            swap(arr, i, minPosition);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
