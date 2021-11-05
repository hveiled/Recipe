import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] charr1 = str1.toCharArray();
        char[] charr2 = str2.toCharArray();

        Map<Character, Integer> map1 = getMap(charr1);
        Map<Character, Integer> map2 = getMap(charr2);
        if (map1.equals(map2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static Map<Character, Integer> getMap(char[] charr) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : charr) {
            if (map.get(Character.toLowerCase(ch)) == null) {
                map.put(Character.toLowerCase(ch), 1);
            } else {
                int c = (int) map.get(Character.toLowerCase(ch));
                map.put(Character.toLowerCase(ch), ++c);
            }
        }
        return map;
    }
}