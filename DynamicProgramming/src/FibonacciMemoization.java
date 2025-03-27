import java.util.Scanner;
import java.util.HashMap;

public class FibonacciMemoization {
    public static int fib (int n,HashMap<Integer, Integer> memo) {
        if (n==0 || n==1){
            return n;
        }
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        int result = fib(n-1,memo)+fib(n-2,memo);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> memo = new HashMap<>();
        while (true){
            int n = sc.nextInt();
            if (n==0){
                break;
            }
            System.out.println(fib(n,memo));
        }

    }
}
