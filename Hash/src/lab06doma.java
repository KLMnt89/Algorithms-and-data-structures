import java.util.Scanner;

public class lab06doma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<Vraboten,Proekt> tabela=new CBHT<>(10);
        for (int i = 0; i < n; i++) {
            String ime=sc.next();
            int godini=sc.nextInt();
            int rabVreme=sc.nextInt();
            int plataPoCas=sc.nextInt();
            Vraboten v=new Vraboten(ime,godini);
            Proekt p=new Proekt(rabVreme,plataPoCas);
            if (tabela.search(v)==null){
                tabela.insert(v,p);
            }
            else{
                SLLNode<MapEntry<Vraboten,Proekt>> dvizi=tabela.search(v);
                Proekt najdobraPonuda=dvizi.element.value;
                if (p.getJobTime()>najdobraPonuda.getJobTime()){
                    tabela.insert(v,p);
                }
            }
            System.out.println(tabela);

        }
    }
}

class Vraboten implements Comparable<Vraboten> {
    String name;
    int age;

    public Vraboten(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return (this.name.equals(((Vraboten) o).name) && (this.age == ((Vraboten) o).age));
    }

    @Override
    public int hashCode() {
        return age + 31 * (name.charAt(0));
    }

    @Override
    public String toString() {
        return "<" + name + ", " + age + ">";
    }

    @Override
    public int compareTo(Vraboten o) {
        return 0;
    }
}

class Proekt{
    int jobTime;
    int salaryPerHour;

    public Proekt(int jobTime, int salary) {
        this.jobTime = jobTime;
        this.salaryPerHour = salaryPerHour;
    }

    public int getJobTime() {
        return jobTime*salaryPerHour;
    }

    @Override
    public String toString() {
        return "<" + jobTime + ", " + salaryPerHour + ">";
    }
}