import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayOperations arrayOps = new ArrayOperations();
        StackOperations stackOps = new StackOperations();
        QueueOperations queueOps = new QueueOperations();
        LinkedListOperations listOps = new LinkedListOperations();
        SearchingOperations searchOps = new SearchingOperations();
        GraphOperations graphOps = new GraphOperations();
        PerformanceComparison perfOps = new PerformanceComparison();

        while (true) {
            System.out.println("\n===== DATA STRUCTURE & GRAPH ANALYZER =====");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt(sc);

            switch (choice) {
                case 1 -> arrayOps.menu(sc);
                case 2 -> stackOps.menu(sc);
                case 3 -> queueOps.menu(sc);
                case 4 -> listOps.menu(sc);
                case 5 -> searchOps.menu(sc);
                case 6 -> graphOps.menu(sc);
                case 7 -> perfOps.runComparison();
                case 8 -> {
                    arrayOps.display();
                    stackOps.display();
                    queueOps.display();
                    listOps.display();
                    graphOps.displayGraph();
                }
                case 9 -> {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static int getValidInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}