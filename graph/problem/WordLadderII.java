package strivers.graph.problem;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/description/
public class WordLadderII implements App {
    @Override
    public void run() {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        String begin = "hot";
        String end = "cog";
        List<List<String>> res = findLadders(begin, end, wordList);
        System.out.println(res);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> resultList = new ArrayList<>();
        if (!wordSet.contains(endWord)) return resultList;

        wordSet.add(beginWord); // we may or may not have beginWord in wordlist, so let's add it
        Map<String, Set<String>> map = new HashMap<>();



        Set<String> backward = new HashSet<>();
        backward.add(endWord);



        boolean found = false; // able to get the path

        while (!backward.isEmpty() && !found) {
            Set<String> temp = new HashSet<>();

            // going from end ensures that we will have lesser number of paths to explore
            for (String s : backward) {


                for (String nb : getNext(s, wordSet)) {

                    if (backward.contains(nb) ) continue;
                    if (beginWord.equals(nb)) found = true;

                    temp.add(nb);
                    map.putIfAbsent(nb, new HashSet<>());
                    map.get(nb).add(s);


                }
                wordSet.remove(s);
//                System.out.println(map);
            }
//            System.out.println();
            backward = temp;
        }


        // printMap(map);
        List<String> list = new ArrayList<>();
        list.add(beginWord);


        // System.out.println(len+" "+wordList.size());
        if (found) dfs(map, resultList, list, beginWord, endWord);
        return resultList;

    }

    private void dfs(Map<String, Set<String>> map, List<List<String>> resultList, List<String> list,
                     String word, String lastWord) {
        if (word.equals(lastWord)) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (String s : map.get(word)) {
            list.add(s);
            dfs(map, resultList, list, s, lastWord);
            list.remove(list.size() - 1);
        }
    }

    private List<String> getNext(String s, Set<String> dict) {
        char[] arr = s.toCharArray();
        List<String> combination = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) continue;
                arr[i] = c;
                String nb = new String(arr);
                if (dict.contains(nb)) combination.add(nb);
            }
            arr[i] = ch;
        }

        return combination;
    }

    private void printMap(Map<String, Set<String>> map) {
        System.out.println("map " + map);
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
