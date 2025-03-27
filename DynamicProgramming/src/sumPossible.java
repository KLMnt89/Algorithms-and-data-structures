import java.util.*;
import java.io.*;

public class sumPossible {
    public static boolean possible(int amount,ArrayList<Integer> numbers,HashMap<Integer,Boolean> memo){
        if (amount==0) return true;
        if (amount<0) return false;
        if (memo.containsKey(amount)) return memo.get(amount);

        for (int num:numbers) {
            int sumNum=amount-num;
            if (possible(sumNum,numbers,memo)) {
                memo.put(amount,true);
                return true;
            }
        }

        memo.put(amount,false);
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int amount = sc.nextInt();
        Boolean dali=possible(amount,arr,new HashMap<Integer,Boolean>());
        System.out.println(dali);
    }
}
/*
3
4 6 10
15
--------------
false
*/