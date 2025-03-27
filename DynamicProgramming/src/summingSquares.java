import java.util.*;
import java.io.*;

public class summingSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)sumSquares(n,new HashMap<>()));
    }

    private static double sumSquares(double n, HashMap<Double, Double> memo) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        double min=Double.POSITIVE_INFINITY;
        for (int i=1;i<=Math.sqrt(n);i++){
            double squares=i*i;
            double numSquares=1 + sumSquares(n-squares,memo);
            if (numSquares<min) min=numSquares;
        }

        memo.put(n,min);
        return min;
    }
}
/*
10
----
2
 */