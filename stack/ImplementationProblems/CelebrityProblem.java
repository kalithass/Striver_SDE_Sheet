package strivers.stack.ImplementationProblems;

import strivers.App;

import java.util.Arrays;

public class CelebrityProblem implements App {

    static int[][] mat = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};

    @Override
    public void run() {
        int n = mat.length;
        int res = findCelebrity(n);
        System.out.println(res);
    }

    public static int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == celebrity) continue;
            if (knows(celebrity, i) || !knows(i, celebrity)) return -1;
        }
        return celebrity;
    }

    static boolean knows(int a, int b) {
        return mat[a][b] == 1;
    }

//    static boolean knows(int a, int b) {
//        return Runner.knows(a, b);
//    }
}
