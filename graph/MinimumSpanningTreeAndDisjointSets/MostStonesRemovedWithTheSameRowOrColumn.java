package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class MostStonesRemovedWithTheSameRowOrColumn implements App {

    @Override
    public void run() {

        int[][] edges = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        int res = removeStones(edges);
        System.out.println(res);
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxColumn = 0;
        for(int[] arr : stones) {
            maxRow = Math.max(maxRow, arr[0]);
            maxColumn = Math.max(maxColumn, arr[1]);
        }

        DisjointSetByRank disJointSet = new DisjointSetByRank(maxColumn+maxRow+1);
        Set<Integer> nodes = new HashSet<>();
        for(int[] arr : stones) {
            int u = arr[0];
            int v = arr[1] + maxRow + 1;
            disJointSet.unionByRank(u, v);
            nodes.add(u);
            nodes.add(v);
        }

        int components = 0;
        for(int element : nodes) {
            if(disJointSet.findParent(element) == element) components++;
        }
        return stones.length- components  ;
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

        public int findParent(int n) {
            if(parent[n] == n) return n;
            return parent[n] = findParent(parent[n]);
        }

        void unionByRank(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if (ulp_u == ulp_v) return;
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            }
            else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            }
            else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }
}
