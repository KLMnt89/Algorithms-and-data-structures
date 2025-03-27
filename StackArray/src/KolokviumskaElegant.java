import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KolokviumskaElegant {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayQueue<String> queue=new ArrayQueue<>(n);
        for (int i=1;i<=n;i++){
            queue.enqueue(br.readLine());
        }
        while (!queue.isEmpty()){
            String line=queue.dequeue();
            String []parts=line.split(" ");
            String name=parts[0];
            int baranja=Integer.parseInt(parts[1]);
            baranja--;
            if (baranja==0){
                System.out.println(name);
            }
            else{
                queue.enqueue(name+" "+baranja);
            }
        }
    }
}
