import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Data Structure and Graph Analyzer ===");
            System.out.println("1. Array operations");
            System.out.println("2. Searching operations");
            System.out.println("3. Stack operations");
            System.out.println("4. Queue operations");
            System.out.println("5. Linked list operations");
            System.out.println("6. Graph operations");
            System.out.println("7. Performance comparison");
            System.out.println("0. Exit");
            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    ArrayOperations.run(scanner);
                    break;
                case 2:
                    SearchingOperations.run(scanner);
                    break;
                case 3:
                    StackOperations.run(scanner);
                    break;
                case 4:
                    QueueOperations.run(scanner);
                    break;
                case 5:
                    LinkedListOperations.run(scanner);
                    break;
                case 6:
                    GraphOperations.run(scanner);
                    break;
                case 7:
                    PerformanceComparison.run(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Please choose a listed option.");
            }
        }

        scanner.close();
        System.out.println("Goodbye.");
    }

    static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Enter a valid integer.");
            }
        }
    }
}
