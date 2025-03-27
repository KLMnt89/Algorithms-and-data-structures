import java.util.Scanner;

public class PovikuvackiBroeviZemja {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        CBHT<String,String> tabela=new CBHT<>(2*n-1);
        for (int i=0;i<n;i++){
            String line=sc.nextLine();
            String []parts=line.split(" ");

            tabela.insert(parts[0],parts[1]);
        }
        String line=sc.nextLine().substring(1);
        char[] lines=line.toCharArray();
        if (lines[0]=='1'){
            System.out.println("SoedinetiAmerikanskiDrzavi");
        }
        else if(lines[0]=='2'){
            String key=line.substring(0,2);
            SLLNode<MapEntry<String,String>> element=tabela.search(key);
            if (element != null) {
                System.out.println(element.element.value);
            } else {
                System.out.println("Nema informacii");
            }
        }else{
            String key=line.substring(0,3);
            SLLNode<MapEntry<String,String>> element=tabela.search(key);
            if (element != null) {
                System.out.println(element.element.value);
            } else {
                System.out.println("Nema informacii");
            }
        }
    }
}

