//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class lab06fax {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        int n=Integer.parseInt(br.readLine());
//        CBHT<String,Person> tabela=new CBHT<>(10*n-1);
//        for (int i = 0; i < n; i++) {
//            String line=br.readLine();
//            String[] tokens=line.split("\\s+");
//            Person p=new Person(tokens[0]+" "+tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]));
//            tabela.insert(tokens[5],p);
//        }
//        br.readLine();
//        int m=Integer.parseInt(br.readLine());
//        int MAX=1159;
//        for(int i=0;i<m;i++){
//            int brojac=0;
//            String line=br.readLine();
//            String[] tokens=line.split("\\s+");
//            String key=tokens[5];
//            SLLNode<MapEntry<String,Person>> dvizi = tabela.search(key);
//            int min=Integer.MAX_VALUE;
//            String minimum="null";
//            if(dvizi!=null){
//                brojac++;
//                String time=dvizi.element.value.getTime().replaceAll("\\:","");
//                int vreme=Integer.parseInt(time);
//                System.out.println(vreme);
//                if (vreme>MAX && vreme<min){
//                    minimum=dvizi.element.toString();
//                    min = vreme;
//                }
//            }
//            String output=key+" has the following number of customers:"+"\n"+brojac;
//            output+="\n"+"The user who logged on earliest after noon from that city is:"+minimum;
//            System.out.println(output);
//        }
//
//    }
//}
//
////class Person{
////    String ime;
////    int budzet;
////    String ip;
////    String time;
////    String grad;
////    int cena;
////
////    public Person(String ime, int budzet, String ip, String time, String grad, int cena) {
////        this.ime = ime;
////        this.budzet = budzet;
////        this.ip = ip;
////        this.time = time;
////        this.grad = grad;
////        this.cena = cena;
////    }
////    public Person(){};
////
////    public String getTime() {
////        return time;
////    }
////
////    @Override
////    public String toString() {
////        String s=ime+" with salary "+budzet+" from address "+ip+" who logged in at "+time;
////        return s;
////    }
////}