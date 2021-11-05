import java.text.DecimalFormat;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = scanner.nextInt();
        double n2 = scanner.nextInt();
        double n3 = scanner.nextInt();

        int i;
        i=(int)((n1/2)+0.5) + (int)((n2/2)+0.5) + (int)((n3/2) + 0.5); //ceil
        System.out.println(i);
    }
}