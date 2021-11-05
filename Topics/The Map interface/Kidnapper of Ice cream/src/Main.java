import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String quote = sc.nextLine();
        String note = sc.nextLine();

        String[] splittedQuote = quote.split("\\s+");
        String[] splittedNote = note.split("\\s+");

        Map<String, Integer> mappedQuote = dictionary(splittedQuote);

        for (String word : splittedNote) {
            if (mappedQuote.containsKey(word)) {
                mappedQuote.put(word, mappedQuote.get(word) - 1);
                if (mappedQuote.get(word) == 0) {
                    mappedQuote.remove(word);
                }
            } else {
                System.out.println("You are busted");
                return;
            }
        }
        System.out.println("You get money");
    }

    public static Map<Integer, String> mapping(String[] splittedString) {
        Map<Integer, String> mappedString = new HashMap<>();
        int i = 0;
        for (String str : splittedString) {
            mappedString.put(++i, str);
        }
        return mappedString;
    }

    public static Map<String, Integer> dictionary(String[] splittedString) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : splittedString) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        return map;
    }
}