package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/kruskal%E2%80%99s-minimum-spanning-tree-algorithm_1082553
public class KruskalAlgorithm implements App {

    @Override
    public void run() {

        int n = 5;
        int m = 6;

        int[][] edges = {
                {1, 2, 6},
                {2, 3, 5},
                {3, 4, 4},
                {1, 4, 1},
                {1, 3, 2},
                {3, 5, 3}
        };


        int res = kruskalMST(n, edges);
        System.out.println(res);
    }

    public static int kruskalMST(int n,int [][]edges) {
        int res = 0;
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        DisjointSetByRank disjoint = new DisjointSetByRank(n);
        for(int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            int weight = arr[2];

            int parOfU = disjoint.findParent(u);
            int parOfV = disjoint.findParent(v);

            if(parOfV != parOfU) {
                disjoint.unionByRank(u, v);
                res += weight;
            }
        }
        return res;
    }

    static class DisjointSetByRank {
        int[] rank;
        int[] parent;

        DisjointSetByRank(int n) {
            rank = new int[n+1];
            parent = new int[n+1];
            for(int i=0;i<=n;i++) {
                parent[i] = i;
            }
        }

        int findParent(int n) {
            if(parent[n] == n) return n;
            return parent[n] = findParent(parent[n]);
        }

        void unionByRank(int u, int v) {
            int parOfU = findParent(u);
            int parOfV =  findParent(v);
            if(rank[parOfU] < rank[parOfV]) {
                parent[parOfU] = parent[parOfV];
            } else if(rank[parOfU] > rank[parOfV]) {
                parent[parOfV] = parent[parOfU];
            } else {
                parent[parOfV] = parent[parOfU];
                rank[parOfU]++;
            }
        }
    }
}
