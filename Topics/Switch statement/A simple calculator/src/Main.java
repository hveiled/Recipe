import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num1 = sc.nextLong();
        String oper = sc.next();
        long num2 = sc.nextLong();

        if (num2 == 0) {
            System.out.println("Division by 0!");
        } else {
            switch (oper) {
                case "+":
                    System.out.println(num1 + num2);
                    break;
                case "-":
                    System.out.println(num1 - num2);
                    break;
                case "*":
                    System.out.println(num1 * num2);
                    break;
                case "/":
                    System.out.println(num1 / num2);
                    break;
                default:
                    System.out.println("Unknown operator");
                    break;
            }
        }
    }
}
