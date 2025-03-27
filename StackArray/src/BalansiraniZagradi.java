import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalansiraniZagradi {
    public static boolean daliBalansiraniZagradi(String izraz){
        LinkedStack<Character> zagradi=new LinkedStack<Character>();
        for (int i = 0; i < izraz.length(); i++){

            if (izraz.charAt(i)=='(' || izraz.charAt(i)=='[' || izraz.charAt(i)=='{'){
                zagradi.push(izraz.charAt(i));
            }
            else if (izraz.charAt(i)==')'){
                if (zagradi.isEmpty()) return false;
                char z=zagradi.pop();
                if (z!='(') return false;
            }
            else if (izraz.charAt(i)==']'){
                if (zagradi.isEmpty()) return false;
                char z=zagradi.pop();
                if (z!='[') return false;
            }
            else if (izraz.charAt(i)=='}'){
                if (zagradi.isEmpty()) return false;
                char z=zagradi.pop();
                if (z!='{') return false;
            }
        }
        if (!zagradi.isEmpty()) return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String izraz=br.readLine();

        if (daliBalansiraniZagradi(izraz)){
            System.out.println("Balansirani");
        }else{
            System.out.println("Ne se balansirani");
        }
    }
}
