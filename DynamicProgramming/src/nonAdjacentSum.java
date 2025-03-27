import java.util.*;

public class nonAdjacentSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(nonAdjSum(list,0,new HashMap<>()));
    }

    private static int nonAdjSum(List<Integer> numbers, int i, HashMap<Integer, Integer> memo) {
        if (i >= numbers.size()) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int result=Math.max(numbers.get(i)+nonAdjSum(numbers,i+2,memo),nonAdjSum(numbers,i+1,memo));
        memo.put(i, result);
        return result;
    }
}
