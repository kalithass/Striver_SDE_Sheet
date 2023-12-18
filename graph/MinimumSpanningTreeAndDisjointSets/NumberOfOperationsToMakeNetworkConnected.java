package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class NumberOfOperationsToMakeNetworkConnected implements App {

    @Override
    public void run() {

        int[][] edges = {
                {0, 1},
                {0, 2},
//                {0, 3},
                {1, 2}
        };
        int n = 4;
        int res = makeConnected(n, edges);
        System.out.println(res);
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        DisjointSetBySize disjointSet = new DisjointSetBySize(n);
        for(int[] arr : connections) {
            int u = arr[0];
            int v = arr[1];
            disjointSet.unionBySize(u, v);
        }
        return disjointSet.getUniqueComponents()-1;
    }

    static class DisjointSetBySize {
        int[] size;
        int[] parent;


        DisjointSetBySize(int n) {
            size = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int n) {
            if(n == parent[n]) return n;
            return parent[n] = findParent(parent[n]);
        }

        public void unionBySize(int u, int v) {
            int parOfU = findParent(u);
            int parOfV = findParent(v);
            if (parOfV == parOfU) return;
            if(size[parOfU] < size[parOfV]) {
                parent[parOfU] = parent[parOfV];
                size[parOfV] += size[parOfU];
            } else {
                parent[parOfV] = parent[parOfU];
                size[parOfU] += size[parOfV];
            }
        }

        public int getUniqueComponents()  {
            int res = 0;
            for(int i=0;i<parent.length;i++) {
                if (parent[i] == i) res++;
            }
            return res;
        }
    }
}
