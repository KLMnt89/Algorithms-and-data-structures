import java.util.ArrayList;
import java.util.Scanner;

public class lab09doma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        AdjacencyListGraph<Integer> graph=new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        int pocetoTeme=sc.nextInt();
        int baranaSuma=sc.nextInt();
        System.out.println(brojNaPatista(graph,pocetoTeme,baranaSuma,pocetoTeme));
    }

    private static int brojNaPatista(AdjacencyListGraph<Integer> graph, int pocetoTeme, int baranaSuma, int momentalnaSuma) {
        if (momentalnaSuma == baranaSuma){
            return 1;
        }
        if (momentalnaSuma>baranaSuma){
            return 0;
        }
        int count=0;
        ArrayList<Integer> neighbors=new ArrayList<>(graph.getNeighbors(pocetoTeme));
        for (int i=0;i<neighbors.size();i++){
            count+=brojNaPatista(graph,neighbors.get(i),baranaSuma,momentalnaSuma+neighbors.get(i));
        }
        return count;
    }
}
