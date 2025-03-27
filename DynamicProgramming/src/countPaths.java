import java.util.*;
import java.io.*;

public class countPaths {
    public static int countPathss(int row, int column,List<List<String>> grid, HashMap<List<Integer>,Integer> memo) {

    if (row==grid.size() || column==grid.get(0).size()){
        return 0;
    }
    if (grid.get(row).get(column).equals("X")){
        return 0;
    }
    if (row==grid.size()-1 && column==grid.get(0).size()-1){
        return 1;
    }
    List<Integer> pos=List.of(row,column);
    if (memo.containsKey(pos)){
        return memo.get(pos);
    }

    int result = countPathss(row+1,column,grid,memo)+countPathss(row,column+1,grid,memo);
    memo.put(pos,result);
    return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row=sc.nextInt();
        int column=sc.nextInt();
        List<List<String>> grid=new ArrayList<>();
        for (int i=0;i<row;i++){
            List<String> list=new ArrayList<>();
            for (int j=0;j<column;j++){
                list.add(sc.next());
            }
            grid.add(list);
        }
        System.out.println(grid);
        System.out.println(countPathss(0,0,grid,new HashMap<>()));
    }
}
/*
4 4
O O O O
O X O O
O O X O
O O O O
-------
4
 */