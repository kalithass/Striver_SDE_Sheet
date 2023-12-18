package strivers.string.hard;

import strivers.App;

//https://leetcode.com/problems/count-and-say/
public class CountAndSay implements App {

    @Override
    public void run() {
        int n = 4;
        String res = countAndSay(n);
//        System.out.println(res);
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
    }

    public String countAndSay(int n) {
        return helper(1, n, "1");
    }

    private String helper(int ind, int n, String s) {
        if(n == ind) return s;
        char prev = s.charAt(0);
        int count =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == prev) count++;
            else {
                sb.append(count).append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(prev);
//        System.out.println(ind+" "+sb);
        return helper(ind+1, n, sb.toString());
    }
}
