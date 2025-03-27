//import java.util.Scanner;
//
//public class KnigaStr252_06 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sc.nextLine();
//        CBHT<String,adresa> tabela=new CBHT<>(5*N-1);
//        for (int i = 0; i < N; i++) {
//            String s = sc.nextLine();
//            String[] parts = s.split(" ");
//            adresa a=new adresa(parts[1],parts[2]);
//            if (tabela.search(parts[0])==null){
//                tabela.insert(parts[0],a);
//            }
//        }
//        int m=sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < m; i++) {
//            String s = sc.nextLine();
//            String[] parts = s.split(" ");
//
//            adresa p = tabela.search(parts[0]).element.value;
//                p.setUlica(parts[1]);
//                String key=tabela.search(parts[0]).element.key;
//                tabela.insert(key,p);
//            }
//        }
////        String line=sc.nextLine();
////        System.out.println(tabela.search(line).element.value);
//
//    }
//}
//
//class adresa implements Comparable<adresa> {
//    String ulica;
//    String broj;
//
//    public adresa(String ulica, String broj){
//        this.ulica = ulica;
//        this.broj = broj;
//    }
//
//    public String getUlica() {
//        return ulica;
//    }
//
//    public void setUlica(String ulica) {
//        this.ulica = ulica;
//    }
//
//    public String getBroj() {
//        return broj;
//    }
//
//    public void setBroj(String broj) {
//        this.broj = broj;
//    }
//    @Override
//    public int compareTo(adresa o) {
//        return this.broj.compareTo(o.broj);
//    }
//    @Override
//    public String toString() {
//        return ulica+" "+broj;
//    }
//}