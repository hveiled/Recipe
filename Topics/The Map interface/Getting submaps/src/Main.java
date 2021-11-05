import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String range = sc.nextLine();
        String[] ran = range.split("\\s+");
        int from = Integer.parseInt(ran[0]);
        int to = Integer.parseInt(ran[1]);
        int number = Integer.parseInt(sc.nextLine());
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < number; i++) {
            String str = sc.nextLine();
            String[] entry = str.split("\\s");
            map.put(Integer.parseInt(entry[0]), entry[1]);
        }
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> val : set) {
            int key = val.getKey();
            if (key >= from && key <= to) {
                System.out.println(val.getKey() + " " + val.getValue());
            }
        }
    }
}