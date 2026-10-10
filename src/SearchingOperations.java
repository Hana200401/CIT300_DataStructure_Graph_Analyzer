import java.util.Arrays;
import java.util.Scanner;

public class SearchingOperations {
    private SearchingOperations() {
    }

    public static void run(Scanner scanner) {
        int size = readPositiveInt(scanner, "Number of elements: ");
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = Main.readInt(scanner, "Element " + i + ": ");
        }
        int target = Main.readInt(scanner, "Value to search for: ");

        int linearIndex = linearSearch(values, target);
        System.out.println("Linear search: " + describeResult(linearIndex));

        int[] sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);
        int binaryIndex = Arrays.binarySearch(sortedValues, target);
        System.out.println("Binary search on a sorted copy: "
                + describeResult(binaryIndex >= 0 ? binaryIndex : -1));
        System.out.println("Sorted copy: " + Arrays.toString(sortedValues));
    }

    static int linearSearch(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static String describeResult(int index) {
        return index >= 0 ? "found at index " + index : "not found";
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            int value = Main.readInt(scanner, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Enter a positive number.");
        }
    }
}
