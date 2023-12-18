package strivers.temp;

import java.util.*;


public class Ideone {

    Random rand = new Random();
    List<Integer> wkPlayers;
    List<Integer> batters;
    List<Integer> allRounders;
    List<Integer> bowlers;

    public static void main(String[] args) throws CloneNotSupportedException {
        int wk = 2;
        int bat = 7;
        int al = 8;
        int bowl = 5;

        Ideone t = new Ideone();

        t.printPlayers(wk, bat, al, bowl);
        t.printCaptainAndViceCaptains();
    }

    private void printCaptainAndViceCaptains() {
        List<Integer> list = getPlayers(4, 2);
        int captain = getSpecialPlayer(list.get(0));
        int viceCaptain = getSpecialPlayer(list.get(1));
        System.out.println("Captain -> " + getPosition(list.get(0)) + ": " + captain);
        System.out.println("Vice captain -> " + getPosition(list.get(1)) + ": " + viceCaptain);
    }

    private int getSpecialPlayer(int ind) {
        int res = 0;
        switch (ind) {
            case 1 :
                res = pickPlayerFromList(wkPlayers);
                break;
            case 2 :
                res = pickPlayerFromList(batters);
                break;
            case 3 :
                res = pickPlayerFromList(allRounders);
                break;
            default :
                res = pickPlayerFromList(bowlers);
                break;
        }
        return res;
    }

    private int pickPlayerFromList(List<Integer> playerdList) {
        int randInd = getPlayers(playerdList.size(), 1).get(0) - 1;
        return playerdList.get(randInd);
    }

    private String getPosition(int ind) {
        String res = "";
        switch (ind) {
            case 1 :
                res = "Wicket Keeper";
                break;
            case 2 :
                res = "Batter";
                break;
            case 3 :
                res ="All rounder";
                break;
            default :
                res = "Bowler";
                break;
        }
        return res;
    }

    private void printPlayers(int wk, int bat, int al, int bowl) {
        int aLen = 0, bLen = 0, cLen = 0, dLen = 0;

        while (true) {
            aLen = getRandomInTheRange(wk);
            bLen = getRandomInTheRange(bat);
            cLen = getRandomInTheRange(al);
            dLen = getRandomInTheRange(bowl);
            System.out.println(aLen+" "+bLen+" "+cLen+" "+dLen);
            if (aLen + bLen + cLen + dLen == 11) break;
        }


        wkPlayers = getPlayers(wk, aLen);
        batters = getPlayers(bat, bLen);
        allRounders = getPlayers(al, cLen);
        bowlers = getPlayers(bowl, dLen);

        System.out.println("wicket keepers" + wkPlayers);
        System.out.println("batters " + batters);
        System.out.println("all rounders " + allRounders);
        System.out.println("bowlers " + bowlers);
    }

    private static List<Integer> getPlayers(int totalPlayers, int numberOfPlayers) {
        Set<Integer> set = new HashSet<>();
        while (set.size() != numberOfPlayers) {
            set.add(getRandomInTheRange(totalPlayers));
        }
        return toList(set);
    }

    private static List<Integer> toList(Set<Integer> set) {
        List<Integer> res = new ArrayList<>();
        for(int element : set) res.add(element);
        return res;
    }

    private static int getRandomInTheRange(int max) {
        return new Ideone().rand.nextInt(max) + 1;
//        return (int) Math.floor(Math.random() *(max - min + 1) + min);
    }
}
