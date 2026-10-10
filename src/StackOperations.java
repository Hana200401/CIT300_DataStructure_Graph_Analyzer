import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackOperations {
    private StackOperations() {
    }

    public static void run(Scanner scanner) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Stack operations (LIFO) ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Back");
            int choice = Main.readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    stack.push(Main.readInt(scanner, "Value to push: "));
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Popped: " + stack.pop());
                    }
                    break;
                case 3:
                    System.out.println(stack.isEmpty() ? "Stack is empty." : "Top: " + stack.peek());
                    break;
                case 4:
                    System.out.println(stack);
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