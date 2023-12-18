package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import java.util.*;

import strivers.App;

//https://leetcode.com/problems/accounts-merge/
public class AccountsMerge implements App {

    @Override
    public void run() {
        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"), // 0
                List.of("John", "johnsmith@mail.com", "john00@mail.com"), // 1
                List.of("Mary", "mary@mail.com"), // 2
                List.of("John", "johnnybravo@mail.com") // 3
        );
        List<List<String>> res = accountsMerge(accounts);
        System.out.println(res);
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> map = new HashMap<>();
        DisjointSetBySize dj = new DisjointSetBySize(n);
        for (int i=0;i< accounts.size();i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String mail = list.get(j);
                if(map.containsKey(mail)) {
                    dj.unionByRank(map.get(mail), i);
                } else {
                    map.put(mail, i);
                }
            }
        }
        List<List<String>> finalList =  new ArrayList<>();
        for(int i=0;i<n;i++) finalList.add(new ArrayList<>());

        for(var entrySet : map.entrySet()) {
            String mail = entrySet.getKey();
            int parent = dj.findParent(entrySet.getValue());
            finalList.get(parent).add(mail);
        }

        List<List<String>> res =  new ArrayList<>();
        for(int i=0;i<n;i++) {
            List<String> list = finalList.get(i);
            if(!list.isEmpty()) {
                Collections.sort(list);
                List<String> resList = new ArrayList<>();
                resList.add(accounts.get(i).get(0));
                resList.addAll(list);
                res.add(resList);
            }
        }
        return res;
    }

    static class DisjointSetBySize {
        int[] rank;
        int[] parent;

        DisjointSetBySize(int n) {
            rank = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++) {
                parent[i] = i;
            }
        }

        int findParent(int n) {
            if(n == parent[n]) return n;
            return parent[n] = findParent(parent[n]);
        }

        void unionByRank(int u, int v) {
            int pairOfU = findParent(u);
            int pairOfV = findParent(v);
            if(pairOfV == pairOfU) return;
            if(rank[pairOfU] < rank[pairOfV]) {
                parent[pairOfU] = pairOfV;
            } else if (rank[pairOfV] < rank[pairOfU]) {
                parent[pairOfV] = pairOfU;
            } else {
                parent[pairOfV] = pairOfU;
                rank[pairOfU]++;
            }
        }
    }
}
