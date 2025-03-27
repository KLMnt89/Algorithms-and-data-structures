import java.util.HashMap;
import java.util.*;

public class countingChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int m=sc.nextInt();
        System.out.println(countChange(m,0,list,new HashMap<>()));
    }

    private static int countChange(int n,int coinIndex,List<Integer> coins, HashMap<List<Integer>, Integer> memo) {
        if (n==0) return 1;
        if (coinIndex>=coins.size()) return 0;

        List<Integer> pos=List.of(n,coinIndex);
        if (memo.containsKey(pos)) return memo.get(pos);
        int total=0;
        int value=coins.get(coinIndex);
        for (int q=0;q*value<=n;q++){
            int subAmount=n-(q*value);
            total+=countChange(subAmount,coinIndex+1,coins,memo);
        }
        memo.put(pos,total);
        return total;
    }
}
/*
3
1 2 3
4
-----
4
 */