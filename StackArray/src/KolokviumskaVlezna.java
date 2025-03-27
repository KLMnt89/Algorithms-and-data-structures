import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KolokviumskaVlezna {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayQueue<String> queue=new ArrayQueue<>(n);
        for (int i=0;i<n;i++){
            queue.enqueue(br.readLine());
        }
        while (!queue.isEmpty()){
            String linija=queue.dequeue();
            String[] parts=linija.split(" ");
            String ime=parts[0];
            int baranja=Integer.parseInt(parts[1]);
            baranja--;
            if (baranja==0){
                System.out.println(ime);
            }
            else{
                queue.enqueue(ime+" "+baranja);
            }
        }
    }
}
