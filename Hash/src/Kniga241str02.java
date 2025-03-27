import java.util.Scanner;

public class Kniga241str02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String,String> tabela=new CBHT<>(5*n-1);
        for (int i = 0; i < n; i++) {
            String line=sc.nextLine();
            String[] parts=line.split(" ");
            if (tabela.search(parts[0]) == null) {
                tabela.insert(parts[0],parts[1]);
            }
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String line=sc.nextLine();
            String[] parts=line.split(" ");
            if (tabela.search(parts[0]) == null) {
                tabela.insert(parts[0],parts[1]);
            }else{
                float prethodenProsek=Float.parseFloat(tabela.search(parts[0]).element.value);
                if (prethodenProsek!=Float.parseFloat(parts[1])) {
                    tabela.insert(parts[0],"Error");
                }
                else{
                    tabela.insert(parts[0],"OK");
                }
            }
        }
        String line=sc.nextLine();
        String rez=tabela.search(line).element.value;
        if (rez.equals("OK")||rez.equals("Error")) {
            System.out.println(rez);
        }else{
            System.out.println("Empty");
        }
    }
}


