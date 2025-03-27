import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class lab06{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        ArrayQueue<Student> nauka_queue=new ArrayQueue<>(n);
        ArrayQueue<Student> scifi_queue=new ArrayQueue<>(n);
        ArrayQueue<Student> istorija_queue=new ArrayQueue<>(n);

        for (int i = 0; i < n; i++){
            String ime=sc.nextLine();
            int nauka=sc.nextInt();
            int scifi=sc.nextInt();
            int istorija=sc.nextInt();
            sc.nextLine();

            Student s = new Student(ime, nauka, scifi, istorija);

            if (s.nauka == 1){
                nauka_queue.enqueue(s);
            }
            else if (s.scifi == 1){
                scifi_queue.enqueue(s);
            }
            else if (s.istorija == 1){
                istorija_queue.enqueue(s);
            }
        }
        while (!nauka_queue.isEmpty() && !scifi_queue.isEmpty() && !istorija_queue.isEmpty()){
            if (!nauka_queue.isEmpty()){
                for (int i=0;i<2 && nauka_queue.isEmpty();i++){
                    Student s = nauka_queue.dequeue();
                    if (s.scifi == 1){
                        scifi_queue.enqueue(s);
                    }
                    else if (s.istorija == 1){
                        istorija_queue.enqueue(s);
                    }
                    else{
                        System.out.println(s.ime);
                    }
                }
            }
            if (!scifi_queue.isEmpty()){
                for (int i = 0; i < 1 && !scifi_queue.isEmpty(); i++){
                    Student s = scifi_queue.dequeue();
                    if (s. istorija == 1){
                        istorija_queue.enqueue(s);
                    }
                    else{
                        System.out.println(s.ime);
                    }
                }
            }
            if (!istorija_queue.isEmpty()){
                for (int i = 0; i < 2 && !istorija_queue.isEmpty(); i++){
                    Student s = istorija_queue.dequeue();
                    System.out.println(s.ime);
                }
            }
        }


    }
}

class Student{
    String ime;
    int nauka;
    int scifi;
    int istorija;

    Student(String ime, int nauka, int scifi, int istorija){
        this.ime=ime;
        this.nauka=nauka;
        this.scifi=scifi;
        this.istorija=istorija;
    }
}