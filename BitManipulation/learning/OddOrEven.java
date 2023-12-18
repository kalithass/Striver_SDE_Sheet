package strivers.BitManipulation.learning;

import strivers.App;

//https://www.codingninjas.com/studio/problems/odd-even_7993579
public class OddOrEven  implements App {

    @Override
    public void run() {
        int num = 3;
        String res = oddEven(num);
        System.out.println(res);
    }

    public static String oddEven(int N){
        return (N & 1) == 1 ? "odd" : "even";
    }
}
