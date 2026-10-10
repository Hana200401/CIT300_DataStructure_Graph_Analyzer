import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListOperations {
    private LinkedListOperations() {
    }

    public static void run(Scanner scanner) {
        LinkedList<Integer> values = new LinkedList<Integer>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Linked list operations ---");
            System.out.println("1. Add to end");
            System.out.println("2. Insert at index");
            System.out.println("3. Remove at index");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("0. Back");
            int choice = Main.readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    values.add(Main.readInt(scanner, "Value to add: "));
                    break;
                case 2:
                    int insertIndex = Main.readInt(scanner, "Insertion index (0-" + values.size() + "): ");
                    if (insertIndex < 0 || insertIndex > values.size()) {
                        System.out.println("Index is out of range.");
                    } else {
                        values.add(insertIndex, Main.readInt(scanner, "Value to insert: "));
                    }
                    break;
                case 3:
                    if (values.isEmpty()) {
                        System.out.println("List is empty.");
                        break;
                    }
                    int removeIndex = Main.readInt(scanner, "Removal index (0-" + (values.size() - 1) + "): ");
                    if (removeIndex < 0 || removeIndex >= values.size()) {
                        System.out.println("Index is out of range.");
                    } else {
                        System.out.println("Removed: " + values.remove(removeIndex));
                    }
                    break;
                case 4:
                    int target = Main.readInt(scanner, "Value to find: ");
                    int foundAt = values.indexOf(target);
                    System.out.println(foundAt >= 0 ? "Found at index " + foundAt : "Not found.");
                    break;
                case 5:
                    System.out.println(values);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Please choose a listed option.");
            }
        }
    }
}
