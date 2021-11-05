import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }
}