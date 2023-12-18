package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

//https://leetcode.com/problems/swim-in-rising-water/
public class SwimInRaisingWaterUsingDisjointSet   implements App {

    @Override
    public void run() {
        int[][] grid = {
                {0, 2},
                {1, 3}
        };
        int res = swimInWater(grid);
        System.out.println(res);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int total = n*n;
        DisjointSetBySize ds = new DisjointSetBySize(total);


        int[] map = new int[total];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[grid[i][j]] =  i*n+j;
            }
        }

        int[] rowIncrement = {1, -1, 0, 0};
        int[] colIncrement = {0, 0, -1, 1};

        for(int res=0;res<total;res++) {
            int row = map[res]/n;
            int col = map[res] - (row*n);
            for(int i=0;i<4;i++) {
                int x = row + rowIncrement[i];
                int y = col + colIncrement[i];
                if(x>=0 && y>=0 && x<n && y<n && grid[x][y]<= res) {
                    int v = (x*n) + y;
                    // int u = (row*n) + col;
                    ds.unionByRank(map[res], v);
                }
            }
            if(ds.findParent(0) == ds.findParent(total-1)) return res;
        }
        return -1;
    }

    static class DisjointSetBySize {
        int[] rank ;
        int[] parent;

        DisjointSetBySize(int n) {
            rank = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++) parent[i] = i;
        }

        int findParent(int n) {
            if(n == parent[n]) return n;
            return parent[n] = findParent(parent[n]);
        }

        void unionByRank(int u, int v) {
            int parOfU = findParent(u);
            int parOfV = findParent(v);
            if(parOfU == parOfV) return;
            if(rank[parOfU] < rank[parOfV]) {
                parent[parOfU] = parOfV;
            } else if (rank[parOfV] < parOfU) {
                parent[parOfV] = parOfU;
            } else {
                parent[parOfV] = parOfU;
                rank[parOfU]++;
            }
        }
    }
}
