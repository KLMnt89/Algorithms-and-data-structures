import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpilKartiPeroMesanje {
    public static int count(int N){
        ArrayQueue<Integer> spil=new ArrayQueue<>(51);
        for (int i=1;i<=N;i++){
            spil.enqueue(i);
        }
        int count=0;
        while (spil.peek()!=N){
            ArrayStack<Integer> stack=new ArrayStack<>(7);
            for (int i=1;i<=7;i++){
                stack.push(spil.dequeue());
            }
            while (!stack.isEmpty()){
                spil.enqueue(stack.pop());
                spil.enqueue(spil.dequeue());
            }
            count++;
        }

        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}
