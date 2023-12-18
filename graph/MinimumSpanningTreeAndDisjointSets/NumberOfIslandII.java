package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/largest-island_840701
public class NumberOfIslandII implements App {

    @Override
    public void run() {
//        int n = 3;
//        int m = 4;
//        int[][] queries = {
//                {1, 1},
//                {1, 2},
//                {2, 3}
//        };
        int n = 4;
        int m = 4;
        int[][] queries = {
                {0, 2},
                {1, 0},
                {3, 2},
                {3, 0},
                {1, 3},
                {2, 2},
                {1, 1}
        };
        int q = queries.length;
        int[] res = numberOfIslandII(n, m, queries, q);
        System.out.println(Arrays.toString(res));
    }

    public static int[] numberOfIslandII(int n, int m, int[][] queries, int q) {

        // visited matrix to identify whether the location is island or sea
        int[][] visited = new int[n][m];
        int[] res = new int[q];

        // treat array as sequential numbers ex 00 -> 0, 01 -> 1 and...
        int totalPoints = n * m;
        DisjointSetBySize ds = new DisjointSetBySize(totalPoints);
        int count = 0;

        // look out on all four direction
        int[] rowIncrement = {-1, 1, 0, 0};
        int[] colIncrement = {0, 0, -1, 1};

        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            int u = (row * m) + col;

            // if the island has already been added there is no need to check again
            if(visited[row][col] == 1) {
                res[i] = count;
                continue;
            }
            visited[row][col] = 1;
            // first increment the count of number of islands
            count++;
            for (int j = 0; j < 4; j++) {
                int x = row + rowIncrement[j];
                int y = col + colIncrement[j];
                if (x >= 0 && y >= 0 && x < n && y < m && visited[x][y] == 1) {
                    int v = (x * m) + y;

                    // if the parent of current island and nearby island is different
                    // we can merge them, so count will be decreased
                    if (ds.findPrent(u) != ds.findPrent(v)) {
                        count--;
                        ds.unionBYRank(u, v);
                    }
                }
            }
            res[i] = count;
        }
        return res;
    }

    static class DisjointSetBySize {
        int[] rank;
        int[] parent;

        DisjointSetBySize(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int findPrent(int n) {
            if (n == parent[n]) return n;
            return parent[n] = findPrent(parent[n]);
        }

        void unionBYRank(int u, int v) {
            int parOfU = findPrent(u);
            int parOfV = findPrent(v);
            if (parOfV == parOfU) return;
            if (rank[parOfU] < rank[parOfV]) {
                parent[parOfU] = parOfV;
            } else if (rank[parOfV] < rank[parOfU]) {
                parent[parOfV] = parOfU;
            } else {
                parent[parOfV] = parOfU;
                rank[parOfU]++;
            }
        }
    }
}
