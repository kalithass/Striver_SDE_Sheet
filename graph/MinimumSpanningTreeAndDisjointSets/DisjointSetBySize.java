package strivers.graph.MinimumSpanningTreeAndDisjointSets;

public class DisjointSetBySize {

    int[] size;
    int[] parent;

    DisjointSetBySize(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int n) {
        if(parent[n] == n){
            return parent[n];
        }
        return parent[n] = findParent(parent[n]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_v == ulp_u) return;
        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
