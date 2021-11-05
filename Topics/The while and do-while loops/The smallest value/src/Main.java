import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int i = 0;
        while (factorial(i) <= num) {
            i++;
        }

        System.out.println(i);
    }

    public static long factorial(int n) {
        int i = 1;
        long res = 1;
        while (i <= n) {
            res *= i;
            i++;
        }
        return res;
    }
}