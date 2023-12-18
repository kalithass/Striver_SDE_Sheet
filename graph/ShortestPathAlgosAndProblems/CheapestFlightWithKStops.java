package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightWithKStops implements App {

    @Override
    public void run() {
        int[][] flights = {
                {0,1,2},
                {1,2,1},
                {2,0,10}
//                {0, 1, 100},
//                {1, 2, 100},
//                {2, 0, 100},
//                {1, 3, 600},
//                {2, 3, 200}
        };
        int n = 3;
        int src = 1;
        int dst = 2;
        int k = 1;
        int res = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(res);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjMatrix = getAdjMatrix(flights, n);
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Pair> queue = new LinkedList<>();
        distance[src] = 0;
        queue.add(new Pair(distance[src], 0, src));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int nodeDistance = pair.distance;
            int nodePrice = pair.price;
            if(nodeDistance > k ) continue;
            for(int[] arr : adjMatrix.get(node)) {
                int element = arr[0];
                int newPrice = nodePrice + arr[1];
                // System.out.println(price[element]+" "+newPrice+" "+element);
                if(newPrice < distance[element]) {
                    // if(nodeDistance < distance[element]) {
                    //     price[element] = Math.min(price[element], newPrice);
                    //     distance[element] = nodeDistance+1;
                    // } else {
                    //     price[element] = newPrice;
                    // }
                    distance[element] = newPrice;
                    queue.add(new Pair(nodeDistance+1,newPrice, element));
                }
            }
        }
        // System.out.println(Arrays.toString(distance));
        // System.out.println(Arrays.toString(price));
        return distance[dst] != Integer.MAX_VALUE ? distance[dst] : -1;
    }

    private List<List<int[]>> getAdjMatrix(int[][] flights, int n) {
        List<List<int[]>> adjMat = new ArrayList<>();
        for(int i=0;i<n;i++) adjMat.add(new ArrayList<>());
        for(int[] arr : flights) {
            adjMat.get(arr[0]).add(new int[]{arr[1],arr[2]});
        }
        return adjMat;
    }

    static class Pair {
        int distance;
        int price;
        int node;

        public Pair(int distance, int price, int node) {
            this.distance = distance;
            this.price = price;
            this.node = node;
        }
    }
}
