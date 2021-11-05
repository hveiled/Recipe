import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static <T> T getElementByIndex(List<T> lst, int index) {
        // write your code here
        if (index < 0) {
            if (index < lst.size() * -1) {
                throw new IndexOutOfBoundsException();
            }
            int i = index + lst.size();
            return lst.get(i);
        } else {
            if (index >= lst.size()) {
                throw new IndexOutOfBoundsException();
            }
            return lst.get(index);
        }
        List<String> list = new LinkedList<>();

    }

    /* Do not change code below */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<String> values = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        final int index = Integer.parseInt(scanner.nextLine());

        try {
            String element = getElementByIndex(values, index);
            System.out.println(element);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception");
        }
    }
}