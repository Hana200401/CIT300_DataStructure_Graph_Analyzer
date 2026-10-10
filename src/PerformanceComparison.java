import java.util.Arrays;
import java.util.Scanner;

public class PerformanceComparison {
    private PerformanceComparison() {
    }

    public static void run(Scanner scanner) {
        int size;
        do {
            size = Main.readInt(scanner, "Number of values to benchmark (positive): ");
            if (size <= 0) {
                System.out.println("Enter a positive number.");
            }
        } while (size <= 0);

        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = i * 2;
        }
        int target = values[size - 1];

        long start = System.nanoTime();
        int linearIndex = SearchingOperations.linearSearch(values, target);
        long linearTime = System.nanoTime() - start;

        int[] sortedValues = Arrays.copyOf(values, values.length);
        start = System.nanoTime();
        int binaryIndex = Arrays.binarySearch(sortedValues, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("Target: " + target);
        System.out.println("Linear search result: index " + linearIndex
                + ", elapsed " + linearTime + " ns");
        System.out.println("Binary search result: index " + binaryIndex
                + ", elapsed " + binaryTime + " ns");
        System.out.println("Note: timings vary by machine and run; binary search requires sorted data.");
    }
}
