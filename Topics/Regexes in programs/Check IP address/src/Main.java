import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipAddress = sc.nextLine();

        String ipRegex =    "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        System.out.println(ipAddress.matches(ipRegex) ? "YES" : "NO");
    }
}