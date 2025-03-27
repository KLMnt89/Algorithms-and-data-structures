import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class KumanovskiDijalekt {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> tabela=new CBHT<>(2*N-1);

        for(int i=0;i<N;i++){
            String []parts=br.readLine().split(" ");
            tabela.insert(parts[0],parts[1]);
        }

        String tekst=br.readLine();




    }
}
