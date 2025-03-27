import java.util.ArrayList;
import java.util.Scanner;

public class Delumno_sraboteni_zadaci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Jobs> lista=new ArrayList<Jobs>();
        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            lista.add(new Jobs(sc.nextInt(),sc.nextInt()));
        }
        lista.sort((p1,p2) -> Float.compare(p2.getEarningsPerHour(),p1.getEarningsPerHour()));
        float hours=40;
        float suma=0;
        for (int i=0;i<lista.size();i++){
            Jobs job=lista.get(i);
            if (job.time<=hours){
                hours-=job.time;
                suma+=job.earnings;
            }
            else{
                suma+=hours*job.getEarningsPerHour();
                break;
            }
        }
        System.out.println(String.format("%.0f",suma));
    }
}
class Jobs{
    float time;
    float earnings;
    public Jobs(float time, float earnings) {
        this.time=time;
        this.earnings=earnings;
    }

    public float getEarningsPerHour(){
        return earnings/time;
    }
}