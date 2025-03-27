import java.util.ArrayList;
import java.util.Scanner;

public class KolokviumskaPractise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Retardi> lista=new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line=sc.nextLine();
            String[] parts=line.split(" ");
            lista.add(new Retardi(parts[0],Integer.parseInt(parts[1])));
        }
        lista.sort((p1,p2) -> p1.baranja > p2.baranja?1 : -1);
        for (Retardi retardi : lista) {
            System.out.println(retardi);
        }
    }
}

class Retardi{
    String name;
    int baranja;

    public Retardi(String name, int baranja) {
        this.name = name;
        this.baranja = baranja;
    }
    @Override
    public String toString() {
        return name;
    }
}
