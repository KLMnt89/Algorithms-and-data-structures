import java.util.Scanner;

public class HashVoHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        CBHT<String,dete> tabela=new CBHT<>(2*n-1);
        for (int i=0;i<n;i++) {
            String line=sc.nextLine();
            String[] parts=line.split(" ");
            dete d=new dete(parts[1],parts[2]);
            tabela.insert(parts[0],d);
        }
        int m=sc.nextInt();
        sc.nextLine();
        CBHT<String,String> ulici=new CBHT<>(2*m-1);
        for (int i=0;i<m;i++) {
            String line=sc.nextLine();
            String[] parts=line.split(" ");
            ulici.insert(parts[0],parts[1]);
        }
        String line=sc.nextLine();
        dete rez=tabela.search(line).element.value;
        String broj=rez.broj;
        String key=rez.ulica;
        String ulica=ulici.search(key).element.value;
        System.out.println(ulica + " " + broj);
    }
}

class dete{
    String ulica;
    String broj;
    public dete(String ulica, String broj){
        this.ulica=ulica;
        this.broj=broj;
    }
}
