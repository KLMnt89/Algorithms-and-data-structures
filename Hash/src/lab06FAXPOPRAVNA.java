import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab06FAXPOPRAVNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        CBHT<String,Integer> kolkuPati=new CBHT<>(10*n-1);
        CBHT<String,Person> najmaloVreme=new CBHT<>(10*n-1);
        for (int i = 0; i < n; i++) {
            String line=br.readLine();
            String[] tokens=line.split("\\s+");
            String vreme1=tokens[4].replaceAll("\\:","");
            int vreme=Integer.parseInt(vreme1);
            Person p=new Person(tokens[0]+" "+tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]));
            if (kolkuPati.search(tokens[5])==null ){
                if (vreme>1159) {
                    najmaloVreme.insert(tokens[5],p);
                    kolkuPati.insert(tokens[5],1);
                }
            }
            else{
                if (vreme > 1159) {
                    kolkuPati.insert(tokens[5],kolkuPati.search(tokens[5]).element.value+1);
                }
                int prethoden=0;
                if (najmaloVreme.search(tokens[5])!=null){
                    prethoden=najmaloVreme.search(tokens[5]).element.value.getTime();
                }
                else {
                    prethoden=0;
                }

                if ((vreme<prethoden || prethoden==0) && vreme>1159){
                    najmaloVreme.insert(tokens[5],p);
                }
            }
        }
        br.readLine();
        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            String line=br.readLine();
            String[] tokens=line.split("\\s+");
            String key=tokens[5];
            SLLNode<MapEntry<String,Integer>> dvizi = kolkuPati.search(key);
            SLLNode<MapEntry<String,Person>> dvizi1 = najmaloVreme.search(key);
            String output="City: "+key+" has the following number of customers:"+"\n";
            String output1="\n"+"The user who logged on earliest after noon from that city is:";
            if (dvizi!=null || dvizi1!=null){
                System.out.print(output+dvizi.element.value);
                System.out.println(output1);
                System.out.println(dvizi1.element.value.toString());
                System.out.println(" ");
            }

        }
    }
}

class Person{
    String ime;
    int budzet;
    String ip;
    String time;
    String grad;
    int cena;

    public Person(String ime, int budzet, String ip, String time, String grad, int cena) {
        this.ime = ime;
        this.budzet = budzet;
        this.ip = ip;
        this.time = time;
        this.grad = grad;
        this.cena = cena;
    }
    public Person(){};

    public int getTime() {
        String vreme=time.replaceAll("\\:","");
        int broj=Integer.parseInt(vreme);
        return broj;
    }

    @Override
    public String toString() {
        String s=ime+" with salary "+budzet+" from address "+ip+" who logged in at "+time;
        return s;
    }
}