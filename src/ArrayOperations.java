import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    private int[] arr = new int[100];
    private int size = 0;
    private int stepCount = 0;

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");
            int ch = Main.getValidInt(sc);

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    insert(Main.getValidInt(sc));
                }
                case 2 -> {
                    System.out.print("Enter value to delete: ");
                    delete(Main.getValidInt(sc));
                }
                case 3 -> {
                    System.out.print("Enter value to search: ");
                    search(Main.getValidInt(sc));
                }
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void insert(int val) {
        if (size >= arr.length) {
            System.out.println("Array is full!");
            return;
        }
        arr[size++] = val;
        System.out.println(val + " inserted. Size = " + size);
    }

    public void delete(int val) {
        stepCount = 0;
        for (int i = 0; i < size; i++) {
            stepCount++;
            if (arr[i] == val) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                    stepCount++;
                }
                size--;
                System.out.println(val + " deleted. Steps = " + stepCount);
                return;
            }
        }
        System.out.println(val + " not found!");
    }

    public void search(int val) {
        stepCount = 0;
        for (int i = 0; i < size; i++) {
            stepCount++;
            if (arr[i] == val) {
                System.out.println(val + " found at index " + i + ". Steps = " + stepCount);
                return;
            }
        }
        System.out.println(val + " not found! Steps = " + stepCount);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(arr, size)));
    }
}