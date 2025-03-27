import java.util.Scanner;

public class IspitSeptemvri2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<String,Integer> tabela=new CBHT<>(100);
        while (true){
            String line=sc.nextLine();
            if (line.equals("#")) break;

            String[] parts = line.split(", ");
            String line1 = parts[0].toLowerCase();
            int strana = Integer.parseInt(parts[1]);

            String[] words=line1.split(" ");
            for (String word : words) {
                tabela.insert(word.toLowerCase(),strana);
            }
        }
        int m=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine().toLowerCase();
            String[] words = line.split(" ");
            SLLNode<MapEntry<String,Integer>> dvizi=null;
            for (String word : words) {
                dvizi=tabela.search(word.toLowerCase());
            }
            if (dvizi!=null){
                System.out.println(dvizi.element.value);
            }else{
                System.out.println("Not found");
            }
        }
        //System.out.println(tabela);
    }
}
