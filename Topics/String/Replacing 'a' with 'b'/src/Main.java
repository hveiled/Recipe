import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder string = new StringBuilder(sc.next());
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a') {
                string.setCharAt(i, 'b');
            }
        }
        System.out.println(string);
    }
}