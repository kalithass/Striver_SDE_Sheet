package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/making-a-large-island/
public class MakingALargeIsland implements App {

    @Override
    public void run() {
        int n = 4;
        int m = 4;
        int[][] grid = {
                {1, 0},
                {0, 1},
//                {1,1},
//                {1,0},
//                {1,1},
//                {1,1}
        };
        int res = largestIsland(grid);
        System.out.println(res);
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        DisjointSetBySize ds = new DisjointSetBySize(n*n);
        int[] rowIncrement = {-1, 1, 0, 0};
        int[] colIncrement = {0, 0, -1, 1};

        for(int row=0;row<n;row++) {
            for (int col=0;col<n;col++) {
                if(grid[row][col] == 0) continue;
                int u = (row*n) + col;
                for(int i=0;i<4;i++) {
                    int x = row + rowIncrement[i];
                    int y = col + colIncrement[i];
                    if(x>=0 && y>=0 && x<n && y<n && grid[x][y] == 1) {
                        int v = (x*n) + y;
                        ds.unionBySize(u, v);
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(ds.size));
//        System.out.println(Arrays.toString(ds.parent));

        int res = n*n;
        for(int row=0;row<n;row++) {
            for (int col=0;col<n;col++) {
                if(grid[row][col] == 1) continue;
                Set<Integer> ultimateParents = new HashSet<>();
//                int u = (row*n) + col;
                for(int i=0;i<4;i++) {
                    int x = row + rowIncrement[i];
                    int y = col + colIncrement[i];
//                    if(row == 0 && col == 1) System.out.println(x+" "+y);
                    if(x>=0 && y>=0 && x<n && y<n && grid[x][y] == 1) {
                        int u = (x*n) + y;
                        ultimateParents.add(ds.findParent(u));
                    }
                }
                int curr = 1;
                for(int element : ultimateParents) {
                    curr += ds.getSize(element);
                }
                res = Math.max(curr, res);
            }
        }

//        for(int i=0;i<n*n;i++) {
//            res = Math.max(res, ds.getSize(i));
//        }

        // this case only executes if all the elements in the grid is 1
        // at that case max will be 0, so wee need to get the maximum
        res = Math.max(res, ds.getSize(0));

        return res;
    }

    static class DisjointSetBySize {
        int[] size;
        int[] parent;

        DisjointSetBySize(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int n) {
            if(n == parent[n]) return n;
            return parent[n] = findParent(parent[n]);
        }

        int getSize(int u) {
            int parOfU = findParent(u);
            return size[parOfU];
        }

        void unionBySize(int u, int v) {
            int parOfU = findParent(u);
            int parOfV = findParent(v);
            if (parOfV == parOfU) return;
            if(size[parOfU] < size[parOfV]) {
                parent[parOfU] = parOfV;
                size[parOfV] += size[parOfU];
            } else {
                parent[parOfV] = parOfU;
                size[parOfU] += size[parOfV];
            }
        }
    }
}
