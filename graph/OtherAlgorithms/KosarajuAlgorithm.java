package strivers.graph.OtherAlgorithms;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://www.codingninjas.com/studio/problems/count-strongly-connected-components-kosaraju-s-algorithm_1171151
public class KosarajuAlgorithm implements App {

    @Override
    public void run() {
        int v = 9;
        int[][] grid = {
//                {0, 1},
//                {1, 2},
//                {1, 4},
//                {2, 3},
//                {3, 2},
//                {4, 0}
                {0,3},
                {1,7},
                {2,5},
                {3,6},
                {4,1},
                {5,8},
                {6,0},
                {7,4},
                {7,5},
                {8,6},
                {8,2}
        };
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int[] ar : grid) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(ar[0]);
            list.add(ar[1]);
            edges.add(list);
        }
        int res = stronglyConnectedComponents(v, edges);
        System.out.println(res);
    }

    public static int stronglyConnectedComponents(int v,  ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adjList = getAdjList(v, edges);
        Stack<Integer> topoSortedStack = new Stack<>();
        int[] visited = new int[v];
        for(int i=0;i<v;i++) {
            if(visited[i] == 0) {
                dfs(visited, i, adjList, topoSortedStack, true);
            }
        }
        List<List<Integer>> reverseAdjList = getReverseAdjList(v, edges);
//        System.out.println(reverseAdjList);
        System.out.println(topoSortedStack);
        visited = new int[v];
        int count = 0;
        while (!topoSortedStack.isEmpty()){
            int node = topoSortedStack.pop();
            if(visited[node] == 0) {
                dfs(visited, node, reverseAdjList, topoSortedStack, false);
//                System.out.println(Arrays.toString(visited));
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[] visited, int node, List<List<Integer>> adjList,
                            Stack<Integer> topoList, boolean topoTraversal) {
        visited[node] = 1;
        for(int element : adjList.get(node)) {
            if (visited[element] == 0) {
                dfs(visited, element, adjList, topoList, topoTraversal);
            }
        }
        if(topoTraversal) topoList.push(node);
    }

    private static List<List<Integer>> getAdjList(int v, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<v;i++) res.add(new ArrayList<>());
        for(List<Integer> list : edges) {
            int from = list.get(0);
            int to = list.get(1);
            res.get(from).add(to);
        }
        return res;
    }

    private static List<List<Integer>> getReverseAdjList(int v, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<v;i++) res.add(new ArrayList<>());
        for(List<Integer> list : edges) {
            int from = list.get(0);
            int to = list.get(1);
            res.get(to).add(from);
        }
        return res;
    }
}
