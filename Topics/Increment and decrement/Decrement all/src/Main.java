import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[4];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 0) {
                numbers[i] -= 1;
            } else {
                numbers[i] -=1;
            }
        }
        for (int n : numbers)
            System.out.print(n + " ");;
    }
}