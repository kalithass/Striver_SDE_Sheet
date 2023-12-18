package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/swim-in-rising-water/
public class SwimInRaisingWater implements App {

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
        Queue<Tuple> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));



        queue.add(new Tuple(0,0, grid[0][0] ));

        int[] rowIncrement = {1, -1, 0, 0};
        int[] colIncrement = {0, 0, -1, 1};
        int[][] visited = new int[n][n];
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int row = tuple.row;
            int col = tuple.col;
            int nodeWeight = tuple.weight;
            // System.out.println(grid[row][col]);
            if(row == n-1 && col == n-1) {
                return nodeWeight;
            }
            // max = Math.max(max, grid[row][col]);

            for(int i=0;i<4;i++) {
                int x = row + rowIncrement[i];
                int y = col + colIncrement[i];
                if(x>=0 && y>=0 && x<n && y<n && visited[x][y] == 0) {
                    visited[row][col] = 1;
                    queue.add(new Tuple(x,y, Math.max(nodeWeight, grid[x][y])));
                }
            }
        }
        return -1;
    }

    static class Tuple {
        int row;
        int col;
        int weight;

        public Tuple(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }
}
