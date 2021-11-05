import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int summ = 0;
        for (int i = 0; i < size; i++) {
            summ += sc.nextInt();
        }
        System.out.println(summ);
    }
}