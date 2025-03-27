import java.util.Scanner;
import java.util.HashMap;

public class TribonacciMemoization {
    public static long trib(int n,HashMap<Integer,Long> memo){
        if (n==0||n==1) return 0;
        if (n==2) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        long result=trib(n-1,memo)+trib(n-2,memo)+trib(n-3,memo);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Long> memo=new HashMap<>();
        while (true){
            int n=sc.nextInt();
            if (n==-1) break;
            System.out.println(trib(n,memo));
        }
    }
}
