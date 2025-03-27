import java.util.Scanner;

public class RazdeliPaVladej {
    public static int binarySearch(int[] arr, int left,int right,int x) {
        if (left<=right){
            int mid = left + (right-left)/2;
            if (arr[mid]==x){
                return mid;
            }
            if (arr[mid]>x){
                return binarySearch(arr,left,mid-1,x);
            }else{
                return binarySearch(arr,mid+1,right,x);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M= sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int result=binarySearch(arr,0,N-1,M);

        if (result==-1){
            System.out.println("Ne postoi");
        }else{
            System.out.println(result);
        }
    }
}
