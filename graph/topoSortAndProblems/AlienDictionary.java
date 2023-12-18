package strivers.graph.topoSortAndProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/alien-dictionary_630423
public class AlienDictionary implements App {

    @Override
    public void run() {
//        String[] arr = {"caa", "aaa", "aab"};
        String[] arr = {"abcd"};
        int k = 4;
        String res = getAlienLanguage(arr, k);
        System.out.println(res);
    }

    public static String getAlienLanguage(String []dictionary, int k) {
        List<List<Integer>> adjMatrix = getAdjMatrix(dictionary, k);
        int[] visitedMatrix = new int[k];
        int[] circleMatrix = new int[k];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++) {
            if (visitedMatrix[i] == 0 && (isCircleFormed(adjMatrix, visitedMatrix, circleMatrix, i, sb))) {
                    return "";

            }
        }
        return sb.reverse().toString();
    }

    private static boolean isCircleFormed(List<List<Integer>> adjMatrix, int[] visitedMatrix, int[] circleMatrix, int node, StringBuilder sb) {
        visitedMatrix[node] = 1;
        circleMatrix[node] = 1;
        for(int element : adjMatrix.get(node)) {
            if(visitedMatrix[element] == 0) {
                if(isCircleFormed(adjMatrix, visitedMatrix, circleMatrix, element, sb)) return true;
            } else {
                if(circleMatrix[element] == 1) return true;
            }
        }
        circleMatrix[node] = 0;
//        System.out.println((char)(node+'a'));
//        System.out.println((char)node + 'a');
        sb.append((char)(node+'a'));
        return false;
    }

    private static List<List<Integer>> getAdjMatrix(String[] dictionary, int k) {
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for(int i=0;i<k;i++) {
            adjMatrix.add(new ArrayList<>());
        }
        for(int i=0;i<dictionary.length-1;i++) {
            String first = dictionary[i];
            String second = dictionary[i+1];
            int len = Math.min(first.length(), second.length());
            for(int j=0;j<len;j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    int parent =  first.charAt(j) - 'a';
                    int child = second.charAt(j) - 'a';
                    adjMatrix.get(parent).add(child);
                    break;
                }
            }
        }
        return adjMatrix;
    }

}
