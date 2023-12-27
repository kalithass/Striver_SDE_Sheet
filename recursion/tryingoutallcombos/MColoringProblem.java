package strivers.recursion.tryingoutallcombos;

import strivers.App;

//https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
public class MColoringProblem implements App {

    @Override
    public void run() {
        int m =2;
        int[][] mat = {{0,1,0},{1,0,1}, {0,1,0}};
        String res = graphColoring(mat, m);
        System.out.println(res);
    }

    public static String graphColoring(int [][]mat, int m) {
        int[] colorMatrix = new int[mat.length+1];
        boolean res = recursiveHelper(mat,m, colorMatrix, 0);
        return res ? "YES" : "NO";
    }

    private static boolean recursiveHelper(int[][] mat, int color, int[] colorMatrix, int node) {
        if (node == mat.length) return true;
        for(int i=1;i<=color;i++) {
            if (isPossibleToColor(colorMatrix, mat, node, i)) {
                colorMatrix[node] = i;
                if (recursiveHelper(mat, color, colorMatrix, node+1)) return true;
                colorMatrix[node] = 0;
            }
        }
        return false;
    }

    private static boolean isPossibleToColor(int[] colorMatrix, int[][] mat,
                                             int node, int currentColor) {
        for(int i=0;i<mat.length;i++) {
            if(mat[node][i] == 1 && colorMatrix[i] == currentColor) return false;
        }
        return true;
    }
}
