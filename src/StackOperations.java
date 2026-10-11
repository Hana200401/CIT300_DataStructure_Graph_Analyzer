import java.util.Scanner;

public class StackOperations {
    private int[] stack = new int[100];
    private int top = -1;

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");
            int ch = Main.getValidInt(sc);

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter value to push: ");
                    push(Main.getValidInt(sc));
                }
                case 2 -> pop();
                case 3 -> peek();
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void push(int val) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow! Cannot push.");
            return;
        }
        stack[++top] = val;
        System.out.println(val + " pushed. Top = " + top);
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }
        System.out.println(stack[top--] + " popped.");
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) System.out.print(stack[i] + " ");
        System.out.println();
    }
}