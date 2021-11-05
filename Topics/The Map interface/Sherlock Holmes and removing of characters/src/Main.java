import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().toLowerCase(Locale.ROOT);
        String str2 = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.println(str1);
        System.out.println(str2);

        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

    }
}