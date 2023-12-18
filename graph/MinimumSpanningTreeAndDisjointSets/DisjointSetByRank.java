package strivers.graph.MinimumSpanningTreeAndDisjointSets;

public class DisjointSetByRank {
    int[] rank;
    int[] parent;

    DisjointSetByRank(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int n) {
        if(parent[n] == n){
            return parent[n];
        }
        return parent[n] = findParent(parent[n]);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_v == ulp_u) return;
        if(rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = parent[ulp_v];
        } else if(rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = parent[ulp_u];
        } else {
            parent[ulp_v] = parent[ulp_u];
            rank[ulp_u]++;
        }
    }
}
