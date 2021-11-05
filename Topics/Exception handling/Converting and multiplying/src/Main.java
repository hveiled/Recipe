import java.util.Scanner;

class Main extends Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = 0;
            String str = sc.nextLine();
            try {
                num = Integer.parseInt(str) * 10;
                if (num == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid user input: " + str);
                continue;
            }
            System.out.println(num);
        }
    }
}