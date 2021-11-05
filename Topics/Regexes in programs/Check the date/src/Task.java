import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String date = scanner.nextLine();
    String dateRegex =  "^((0?[1-9]|[12][0-9]|3[01])[\\/\\-\\.](0?[1-9]|1[012])[\\/\\-\\.]\\d{4})|" +
                      "(\\d{4}[\\/\\-\\.](0?[1-9]|1[012])[\\/\\-\\.](0?[1-9]|[12][0-9]|3[01]))$";

    System.out.println(date.matches(dateRegex) ? "Yes" : "No");
  }
}
