import java.util.*;
import java.io.*;

public class maxPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row=sc.nextInt();
        int column=sc.nextInt();
        List<List<Integer>> grid=new ArrayList<>();
        for (int i=0;i<row;i++){
            List<Integer> list=new ArrayList<>();
            for (int j=0;j<column;j++){
                list.add(sc.nextInt());
            }
            grid.add(list);
        }
        System.out.println(grid);
        System.out.println((int)pathSum(0,0,grid,new HashMap<>()));
    }

    private static double pathSum(int row, int column, List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {
        if (row==grid.size() || column==grid.get(0).size()){
            return Double.NEGATIVE_INFINITY;
        }
        if (row==grid.size()-1 && column==grid.get(0).size()-1){
            return grid.get(row).get(column);
        }
        List<Integer> pos=List.of(row,column);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double result=grid.get(row).get(column)+Math.max(pathSum(row+1,column,grid,memo),pathSum(row,column+1,grid,memo));
        memo.put(pos,result);
        return result;
    }
}
/*
3 3
1 2 3
4 5 6
7 8 9
----------
29
 */