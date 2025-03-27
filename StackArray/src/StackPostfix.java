import java.util.Scanner;

public class StackPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<Integer> stack=new ArrayStack<>(100);
        String izraz=sc.nextLine();
        String[] znaci=izraz.split(" ");

        for (int i = 0; i < znaci.length; i++) {
            String c=znaci[i];
            if (stack.size()>=2){
                if (c.equals("+")){
                    stack.push(stack.pop()+stack.pop());
                }
                else if (c.equals("-")){
                    stack.push(stack.pop()-stack.pop());
                }
                else if (c.equals("*")){
                    stack.push(stack.pop()*stack.pop());
                }
                else if (c.equals("/")){
                    stack.push(stack.pop()/stack.pop());
                }
                else {
                    stack.push(Integer.parseInt(c));
                }
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }

        if (stack.isEmpty()){
            System.out.println("Stack is empty");
        }
        else {
            System.out.println(stack.pop().floatValue());
        }
    }
}
