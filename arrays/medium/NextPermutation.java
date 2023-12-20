package strivers.arrays.medium;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation implements App {

    @Override
    public void run() {
        int[] arr = {1,2,3,7,8,9,5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }


    /*
            1. n-2 to 0 find the first i where a[i] < a[i+1] ( call it as change)
            2. if change = -1 (all the elements in the left are greater), reverse the entire array
            3. n-1 to change+1 find the smallest number which is greater than arr[change] (as the right part is sorted in descending searching
            from right to left is good choice) take this point as j
            4. swap change and j
            5. reverse change+1 to n-1

            ex:
            5 4 7 6 5 4 2
            change = 1, j = 4

            step 4 -> 5 5 7 6 4 4 2
            step 5 -> 5 5 2 4 4 6 7
     */
    public void nextPermutation(int[] a) {
        // step 1
        int change = -1;
        int n = a.length;
        for(int i = n-2; i>=0; i--) {
            if(a[i]<a[i+1]) {
                change = i;
                break;
            }
        }

        // step 2
        if(change == -1) {
            reverse(a, 0, n-1);
            return;
        }

        // step 3
        int j = change;
        for(int i=n-1; i>change; i--) {
            if(a[i] > a[change]) {
                j = i;
                break;
            }
        }

        // step 4
        swap(a, change, j);

        // step 5
        reverse(a, change+1, n-1);;
    }

    private void reverse(int[] a, int start, int end) {
        while(start<= end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
