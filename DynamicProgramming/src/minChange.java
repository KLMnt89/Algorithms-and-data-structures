import java.util.*;
import java.io.*;

public class minChange {
    public static int change(int amount,ArrayList<Integer> list,HashMap<Integer,Integer> memo){
        if (amount == 0) return 0;
        if (amount<0) return -1;
        if (memo.containsKey(amount)) return memo.get(amount);

        int minCoins=-1;
        for (int coin:list){
            int subAmount=amount-coin;
            int subCoins=change(subAmount,list,memo);
            if (subCoins!=-1){
                int numCoins=subCoins+1;
                if (numCoins<minCoins || minCoins==-1){
                    minCoins=numCoins;
                }
            }
        }
        memo.put(amount,minCoins);
        return minCoins;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int amount = sc.nextInt();
        int result=change(amount,arr,new HashMap<>());
        System.out.println(result);
    }
}
/*
3
2 3 4
6
--------------
2
 */
