package strivers.Trie.problems.CountDistincTSubstrings;

import strivers.App;


//https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292
public class CountOfDistinctSubstrings implements App {

    @Override
    public void run() {
        int res = countDistinctSubstrings("abab");
        System.out.println(res);
    }

    public static int countDistinctSubstrings(String s)
    {
        Trie trie = new Trie();
        trie.insertAndUpdateCount(s);
        return trie.count + 1;
    }
}
