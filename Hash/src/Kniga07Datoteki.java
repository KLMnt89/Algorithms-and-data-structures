//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Kniga07Datoteki {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        CBHT<String,ArrayList<pathFile>> tabela=new CBHT<>(2*n-1);
//        for (int i = 0; i < n; i++) {
//            String line = sc.nextLine();
//            String[] words = line.split(" ");
//            String path=words[0];
//            String file=words[1];
//            String content=words[2];
//            pathFile pf=new pathFile(content,file);
//            //tabela.insert(path,pf);
//        }
//        int m = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < m; i++) {
//            String line = sc.nextLine();
//            String[] words = line.split(" ");
//            String command=words[0];
//            if (command.equals("add")) {
//                if (tabela.search(words[1]) == null) {
//                    ArrayList<pathFile> lista=new ArrayList<>();
//                    lista.add(new pathFile(words[2],words[3]));
//                    tabela.insert(words[1],lista);
//                }else {
//                    ArrayList<pathFile> lista=tabela.search(words[1]).element.value;
//                    lista.add(new pathFile(words[2],words[3]));
//                    tabela.insert(words[1],lista);
//                }
//            }
//            else if (command.equals("delete")) {
//                SLLNode<MapEntry<String,ArrayList<pathFile>>> dvizi=tabela.search(words[1]);
//
//                if (dvizi!=null) {
//                    ArrayList<pathFile> lista=dvizi.element.value;
//                    for (pathFile pf:lista) {
//                        if (pf.content.equals(words[2])) {
//                            dvizi.element.value.remove(pf);
//                        }
//                    }
//                }
//            }
//            else if (command.equals("find")) {
//               // SLLNode<MapEntry<String,pathFile>> dvizi=tabela.search(words[1]);
//
////                if (dvizi!=null ) {
////                    pathFile prethoden=dvizi.element.value;
////                    if (prethoden.content.equals(words[3])){
////                        System.out.println("true");
////                    }else {
////                        System.out.println("false");
////                    }
////                }
////                else {
////                    System.out.println("false");
////                }
//            }
//
//        }
//        String line = sc.nextLine();
//
//        findFileByName(tabela,"("+line+")");
//
//    }
//
//    private static void findFileByName(CBHT<String,ArrayList<pathFile>> tabela, String word) {
//        ArrayList<String> results=new ArrayList<>();
//
//        for (int i=0;i<tabela.tableSize();i++){
//
//            SLLNode<MapEntry<String,ArrayList<pathFile>>> dvizi=tabela.buckets[i];
//            while (dvizi!=null){
//                MapEntry<String, ArrayList<pathFile>> entry=dvizi.element;
//                //System.out.println(entry.value.content);
//                if (entry.value.content.equals(word)){
//                    results.add(entry.key+entry.value.file);
//                }
//                dvizi=dvizi.succ;
//            }
//
//        }
//
//        if (!results.isEmpty()) {
//            for (String path:results) {
//                System.out.println(path);
//            }
//        }else{
//            System.out.println("not found");
//        }
//    }
//}
//
//class pathFile{
//    String content;
//    String file;
//
//    public pathFile(String file, String content) {
//
//        this.file = file;
//        this.content = content;
//    }
//}
//
