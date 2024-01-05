package strivers.graph.problem.wordLadder1;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class WordLadder1Naive implements App {
    @Override
    public void run() {
       List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        String begin = "hot";
        String end = "cog";
        int res = ladderLength(begin, end, wordList);
        System.out.println(res);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set =  new HashSet<>(wordList);
        queue.add(new Pair(0, new StringBuilder(beginWord)));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            StringBuilder sb = pair.stringBuilder;
            int depth  = pair.depth;
            if(endWord.contentEquals(sb)) return depth+1;
            for(int i=0;i<sb.length();i++) {
                for(char ch='a';ch<='z';ch++) {
                    char prev = sb.charAt(i);
                    sb.setCharAt(i, ch);
                    if(set.contains(sb.toString())) {
                        queue.add(new Pair(depth+1, new StringBuilder(sb)));
                        set.remove(sb.toString());
                    }
                    sb.setCharAt(i, prev);
                }
            }
        }
        return 0;
    }

    static class Pair {
        int depth;
        StringBuilder stringBuilder;

        Pair(int depth, StringBuilder stringBuilder) {
            this.depth = depth;
            this.stringBuilder = stringBuilder;
        }

        @Override
        public String toString() {
            return  stringBuilder.toString();
        }
    }
}
