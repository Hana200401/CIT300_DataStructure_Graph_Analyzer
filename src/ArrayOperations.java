import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    private ArrayOperations() {
    }

    public static void run(Scanner scanner) {
        int[] values = new int[0];
        boolean running = true;

        while (running) {
            System.out.println("\n--- Array operations ---");
            System.out.println("1. Create/replace array");
            System.out.println("2. Display array");
            System.out.println("3. Update element");
            System.out.println("4. Sort array");
            System.out.println("0. Back");
            int choice = Main.readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    int size = readNonNegativeInt(scanner, "Number of elements: ");
                    values = new int[size];
                    for (int i = 0; i < size; i++) {
                        values[i] = Main.readInt(scanner, "Element " + i + ": ");
                    }
                    break;
                case 2:
                    System.out.println(Arrays.toString(values));
                    break;
                case 3:
                    if (values.length == 0) {
                        System.out.println("Create a non-empty array first.");
                        break;
                    }
                    int index = Main.readInt(scanner, "Index to update (0-" + (values.length - 1) + "): ");
                    if (index < 0 || index >= values.length) {
                        System.out.println("Index is out of range.");
                    } else {
                        values[index] = Main.readInt(scanner, "New value: ");
                    }
                    break;
                case 4:
                    Arrays.sort(values);
                    System.out.println("Array sorted.");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Please choose a listed option.");
            }
        }
    }

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            int value = Main.readInt(scanner, prompt);
            if (value >= 0) {
                return value;
            }
            System.out.println("Enter zero or a positive number.");
        }
    }
}
