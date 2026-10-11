import java.util.Scanner;

public class QueueOperations {
    private int[] queue = new int[100];
    private int front = 0, rear = -1, count = 0;

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek/Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");
            int ch = Main.getValidInt(sc);

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter value to enqueue: ");
                    enqueue(Main.getValidInt(sc));
                }
                case 2 -> dequeue();
                case 3 -> peek();
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void enqueue(int val) {
        if (count == queue.length) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        count++;
        System.out.println(val + " enqueued. Size = " + count);
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return;
        }
        int val = queue[front];
        front = (front + 1) % queue.length;
        count--;
        System.out.println(val + " dequeued.");
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }
}