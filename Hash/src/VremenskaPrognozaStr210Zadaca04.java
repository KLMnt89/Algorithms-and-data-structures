import java.util.*;
import java.io.*;

public class VremenskaPrognozaStr210Zadaca04 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        CBHT<String,ArrayList<Merenje>> tabela=new CBHT<>(2*n-1);
        for (int i=0;i<n;i++){
            String line=sc.nextLine();
            String []parts=line.split(" ");
            String city=parts[0];
            Merenje m=new Merenje(parts[1],parts[2],Float.parseFloat(parts[3]));
            if (tabela.search(city)==null){
                ArrayList<Merenje> lista=new ArrayList<>();
                lista.add(m);
                tabela.insert(city,lista);
            }else{
                ArrayList<Merenje> lista=tabela.search(city).element.value;
                lista.add(m);
                tabela.insert(city,lista);
            }
        }
        String line=sc.nextLine();
        ArrayList<Merenje> lista=tabela.search(line).element.value;
        lista.sort((p1,p2) -> p1.odCasot.compareTo(p2.odCasot));
        System.out.println(line+":");
        for (Merenje m: lista){
            System.out.println(m);
        }
    }
}

class Merenje{
    String odCasot;
    String doCasot;
    float temperatura;

    public Merenje(String odCasot, String doCasot, float temperatura){
        this.odCasot=odCasot;
        this.doCasot=doCasot;
        this.temperatura=temperatura;
    }

    @Override
    public String toString(){
        return odCasot+" - "+doCasot+" "+String.format("%.2f",temperatura);
    }
}


