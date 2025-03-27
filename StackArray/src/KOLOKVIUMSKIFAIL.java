import java.util.*;

public class KOLOKVIUMSKIFAIL {
    public static void Sortiraj(LinkedQueue<Person> redica){
        ArrayList<Person> lista = new ArrayList<>();
        while (!redica.isEmpty()){
            lista.add(redica.dequeue());
        }

        lista.sort((p1,p2) -> Integer.compare(p1.baranja,p2.baranja));

        for (Person person : lista){
            redica.enqueue(person);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedQueue<Person> redica=new LinkedQueue<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int obrski=sc.nextInt();
            redica.enqueue(new Person(name, obrski));
        }

        Sortiraj(redica);
        while (!redica.isEmpty()){
            System.out.println(redica.dequeue());
        }
    }
}

class Person {
    String ime;
    int baranja;

    public Person(String ime, int baranja) {
        this.ime = ime;
        this.baranja = baranja;
    }

    @Override
    public String toString() {
        return ime;
    }
}
//5
//NendaAncev 3
//HristinaMisajloska 2
//AntonPenkov 5
//JovanTemkov 2
//SlaveBurgerovic 3
