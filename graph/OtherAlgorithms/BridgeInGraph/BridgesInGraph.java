package strivers.graph.OtherAlgorithms.BridgeInGraph;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/critical-connections-in-a-network/
public class BridgesInGraph implements App {

    @Override
    public void run() {
        int[][] grid = {
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for(int[] ar : grid) {
            List<Integer> list = new ArrayList<>();
            list.add(ar[0]);
            list.add(ar[1]);
            connections.add(list);
        }
        int n = 4;
        List<List<Integer>> res = criticalConnections(n, connections);
        System.out.println(res);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = getAdjList(n, connections);

        int[] timeOfInsertion = new int[n];
        int[] minTimeToReach = new int[n];
        int insertionTime = 1;

        int[] visited = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                findBridges(visited, i, adjList, i, timeOfInsertion, minTimeToReach, insertionTime, res);
            }
        }
        return res;
    }

    private void findBridges(int[] visited, int node, List<List<Integer>> adjList, int parent,
                             int[] timeOfInsertion, int[] minTimeToReach, int insertionTime,
                             List<List<Integer>> res) {
        visited[node] = 1;
        timeOfInsertion[node] = insertionTime;
        minTimeToReach[node] = insertionTime;
        for(int element : adjList.get(node)) {
            if(visited[element] == 0) {
                findBridges(visited, element, adjList, node, timeOfInsertion, minTimeToReach, insertionTime+1, res);
            }
        }
        for(int adjNode : adjList.get(node)) {
            if(minTimeToReach[adjNode] < minTimeToReach[node] && adjNode != parent) {
                minTimeToReach[node] = minTimeToReach[adjNode];
            }
        }
        if(minTimeToReach[node] > minTimeToReach[parent]) res.add(List.of(parent, node));
    }

    private List<List<Integer>> getAdjList(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++) res.add(new ArrayList<>());

        for(List<Integer> list : connections) {
            int u = list.get(0);
            int v = list.get(1);
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
    }
}
