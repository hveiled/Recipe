import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        long sum = 1;
        while (from < to) {
            sum *= from;
            from++;
        }
        System.out.println(sum);
    }
}