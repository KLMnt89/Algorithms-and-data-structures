import java.util.Map;
import java.util.Scanner;

public class VrabotenMenadzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String,Integer> tabela=new CBHT<>(3*n-1);
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String []parts=s.split(",");
            if (tabela.search(parts[1])==null){
                SLLNode<MapEntry<String,Integer>> podVraboten=tabela.search(parts[0]);
                if (podVraboten!=null){
                    int value=podVraboten.element.value;
                    tabela.insert(parts[1],value+1);
                }else{
                    tabela.insert(parts[1],1);
                }

            }else{
                SLLNode<MapEntry<String,Integer>> dvizi=tabela.search(parts[1]);
                String key=dvizi.element.key;
                int value=dvizi.element.value+1;

                tabela.insert(parts[1],value);
            }
        }
        for (int i = 0; i < tabela.buckets.length; i++) {
            SLLNode<MapEntry<String,Integer>> dvizi=tabela.buckets[i];
            while (dvizi!=null){
                System.out.println(dvizi.element.key+ ": " + dvizi.element.value);
                dvizi=dvizi.succ;
            }
        }
    }
}
/*
6
Aleksandra,Marko
Beti,Marko
Marko,Filip
Darko,Elena
Elena,Filip
Filip,Filip
---------------
Elena: 1
Filip: 5
Marko: 2
 */