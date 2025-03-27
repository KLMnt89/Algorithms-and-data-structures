import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DvaSteka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedStack<String> functions = new LinkedStack<>();
        LinkedStack<Integer> counts = new LinkedStack<>();
        String maxCallingFunction = null;
        int maxCalls=0;
        int n=Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line=br.readLine();

            if (line.startsWith("Call")){
                String imeFunkcija=line.split(" ")[1];
                functions.push(imeFunkcija);
                counts.push(0);
            }
            else if (line.startsWith("Return")){
                if (!functions.isEmpty()){
                    String zavrsenaFunkcija=functions.pop();
                    int calls=counts.pop();

                    if (calls>maxCalls){
                        maxCalls=calls;
                        maxCallingFunction=zavrsenaFunkcija;
                    }
                    if (!counts.isEmpty()){
                        counts.push(counts.pop()+1);
                    }
                }
            }
        }
        System.out.println(maxCallingFunction+" "+maxCalls);

    }
}
