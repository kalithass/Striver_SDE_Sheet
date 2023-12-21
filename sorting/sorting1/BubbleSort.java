package strivers.sorting.sorting1;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/description/
public class BubbleSort implements App {

    @Override
    public void run() {
        int[] arr = {6,5,3,2,8,10,9};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    void bubbleSort(int[] arr, int n) {
        for(int i=0;i<n;i++) {
            boolean isSwap = false;
            for(int j=0;j<n-1;j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    isSwap = true;
                }
            }

            if(isSwap == false) return;
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
