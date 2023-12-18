package strivers.greedy.easy;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/find-minimum-number-of-coins_975277
public class MinCoinsToMakeGivenValue implements App {

    @Override
    public void run() {
        List<Integer> res = MinimumCoins(50);
        System.out.println(res);
    }

    public static List<Integer> MinimumCoins(int n) {
        List<Integer> coin = new ArrayList<>();
        while(n != 0){
            if(n >= 1000){
                n = n-1000;
                coin.add(1000);
            }
            else if( n >= 500 ){
                n = n-500;
                coin.add(500);
            }
            else if( n >= 100 ){
                n = n-100;
                coin.add(100);
            }
            else if( n >= 50 ){
                n = n-50;
                coin.add(50);
            }
            else if( n >= 20 ){
                n = n-20;
                coin.add(20);
            }
            else if( n >= 10 ){
                n = n-10;
                coin.add(10);
            }
            else if( n >= 5 ){
                n = n-5;
                coin.add(5);
            }
            else if( n >= 2 ){
                n = n-2;
                coin.add(2);
            }
            else if( n >= 1 ){
                n = n-1;
                coin.add(1);
            }
        }

        return coin;
    }
}
