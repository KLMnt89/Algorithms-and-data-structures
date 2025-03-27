import java.util.Stack;
import java.util.Scanner;

class FunctionValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true) {
            String line = scanner.nextLine().trim();

            if (line.equals("x")) {
                break;
            }

            if (line.startsWith("func")) {
                stack.push(line);
            } else if (line.startsWith("endfunc")) {

                if (stack.isEmpty() || !stack.peek().equals("func" + line.substring(7))) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            }
        }


        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        scanner.close();
    }
}