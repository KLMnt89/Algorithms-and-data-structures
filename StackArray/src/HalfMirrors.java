import java.util.Scanner;

public class HalfMirrors {
    public static void mirrorHalves(ArrayQueue<Integer> queue){
        if (queue==null || queue.size()%2!=0){
            throw new IllegalArgumentException();
        }
//        if (queue.size()==0){
//            return;
//        }
        int half=queue.size()/2;
        ArrayStack<Integer> stek=new ArrayStack<>(half);
        for (int i=0;i<half;i++){
            int elem=queue.dequeue();
            stek.push(elem);
            queue.enqueue(elem);
        }
        while (!stek.isEmpty()){
            queue.enqueue(stek.pop());
        }
        for (int i=0;i<half;i++){
            int elem=queue.dequeue();
            stek.push(elem);
            queue.enqueue(elem);
        }
        while (!stek.isEmpty()){
            queue.enqueue(stek.pop());
        }


        while (!queue.isEmpty()){
            System.out.print(queue.dequeue()+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayQueue<Integer> queue=new ArrayQueue<>(2*n+1);
        for (int i = 0; i < n; i++) {
            queue.enqueue(sc.nextInt());
        }
        mirrorHalves(queue);
    }
}
