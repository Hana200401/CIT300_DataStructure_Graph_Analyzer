import java.util.Arrays;
import java.util.Scanner;

public class SearchingOperations {
    private int[] data = {10, 25, 30, 45, 50, 65, 70, 85, 90, 100};

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- SEARCHING OPERATIONS ---");
            System.out.println("Array (sorted): " + Arrays.toString(data));
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Both");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter choice: ");
            int ch = Main.getValidInt(sc);

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter value to search: ");
                    linearSearch(Main.getValidInt(sc));
                }
                case 2 -> {
                    System.out.print("Enter value to search: ");
                    binarySearch(Main.getValidInt(sc));
                }
                case 3 -> {
                    System.out.print("Enter value to search: ");
                    compare(Main.getValidInt(sc));
                }
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public int linearSearch(int key) {
        int steps = 0;
        for (int i = 0; i < data.length; i++) {
            steps++;
            if (data[i] == key) {
                System.out.println("Linear Search: Found at index " + i + " | Steps = " + steps);
                return steps;
            }
        }
        System.out.println("Linear Search: Not found | Steps = " + steps);
        return steps;
    }

    public int binarySearch(int key) {
        int low = 0, high = data.length - 1, steps = 0;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (data[mid] == key) {
                System.out.println("Binary Search: Found at index " + mid + " | Steps = " + steps);
                return steps;
            } else if (data[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Binary Search: Not found | Steps = " + steps);
        return steps;
    }

    public void compare(int key) {
        System.out.println("\n=== SEARCH COMPARISON for key = " + key + " ===");
        long start = System.nanoTime();
        int linSteps = linearSearch(key);
        long linTime = System.nanoTime() - start;

        start = System.nanoTime();
        int binSteps = binarySearch(key);
        long binTime = System.nanoTime() - start;

        System.out.println("\n--- RESULT ---");
        System.out.println("Linear Search : Steps = " + linSteps + " | Time = " + linTime + " ns");
        System.out.println("Binary Search : Steps = " + binSteps + " | Time = " + binTime + " ns");
        System.out.println("Complexity: Linear = O(n), Binary = O(log n)");
    }
}
