package strivers.greedy.easy;

import strivers.App;

import java.util.Arrays;
import java.util.Comparator;

//https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
public class FractionalKnapsack implements App {

    @Override
    public void run() {
        Item i1 = new Item(60, 10);
        Item i2 = new Item(100, 20);
        Item i3 = new Item(120, 30);
        Item[] arr = {i1, i2, i3};
        int w = 50;
        int n = 3;
        double res = fractionalKnapsack(w, arr, n);
        System.out.println(res);
    }


    double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, (i1, i2) -> Double.compare(i2.value / (double) i2.weight, i1.value / (double) i1.weight));

        int tempWeight = W;
        double res = 0;
        for (Item i : arr) {
            if(tempWeight - i.weight >= 0) {
                tempWeight = tempWeight - i.weight;
                res += i.value;
            } else {
                double ratio = i.value/(double)i.weight;
                res += tempWeight * ratio;
                tempWeight = 0;
            }
        }

        return res;
    }
}

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}
