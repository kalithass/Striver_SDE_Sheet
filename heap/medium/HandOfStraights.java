package strivers.heap.medium;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/hand-of-straights/
public class HandOfStraights implements App {

    @Override
    public void run() {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        boolean res = isNStraightHand(hand, 3);
        System.out.println(res);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        return usingMap(hand, groupSize);
    }

    private static boolean usingMap(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int element : hand) {
            hm.put(element, hm.getOrDefault(element, 0)+1);
        }
        Arrays.sort(hand);
        for(int element : hand) {
            int elementValue = hm.getOrDefault(element, 0);
            if(elementValue == 0) continue;
            //  List<Integer> list =  new ArrayList<>();
            //  list.add(element);
            hm.put(element, elementValue-1);
            for(int i = 1; i< groupSize; i++) {
                int nextValue = element+i;
                int val = hm.getOrDefault(nextValue, 0);
                if(val == 0) return false;
                hm.put(nextValue, val-1);
            }
            // System.out.println(list+" "+hm);
        }
        return true;
    }
}
