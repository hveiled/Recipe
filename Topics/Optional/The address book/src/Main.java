import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Optional<String> optAddress = AddressBook.getAddressByName(name);

        Optional<String> optName = Optional.of(name);
        if (optAddress.isPresent()) {
            System.out.print(optName.get() + " lives at ");
        }
        System.out.println(optAddress.orElse("Unknown"));
    }
}

/* Please, do not modify the code below */
class AddressBook {
    private static Map<String, String> namesToAddresses = new HashMap<>();

    static {
        namesToAddresses.put("Pansy Barrows", "63 Shub Farm Drive, Cumberland, RI 02864");
        namesToAddresses.put("Kevin Bolyard", "9526 Front Court, Hartsville, SC 29550");
        namesToAddresses.put("Earl Riley", "9197 Helen Street, West Bloomfield, MI 48322");
        namesToAddresses.put("Christina Doss", "7 Lincoln St., Matawan, NJ 07747");
    }

    static Optional<String> getAddressByName(String name) {
        return Optional.ofNullable(namesToAddresses.get(name));
    }
}
