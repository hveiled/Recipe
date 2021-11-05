import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{12,}$";
        System.out.println(password.matches(regex) ? "YES" : "NO");
    }
}