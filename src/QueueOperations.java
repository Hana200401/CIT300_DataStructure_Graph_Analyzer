import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueOperations {
    private QueueOperations() {
    }

    public static void run(Scanner scanner) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Queue operations (FIFO) ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Back");
            int choice = Main.readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    queue.offer(Main.readInt(scanner, "Value to enqueue: "));
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Dequeued: " + queue.remove());
                    }
                    break;
                case 3:
                    System.out.println(queue.isEmpty() ? "Queue is empty." : "Front: " + queue.peek());
                    break;
                case 4:
                    System.out.println(queue);
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
