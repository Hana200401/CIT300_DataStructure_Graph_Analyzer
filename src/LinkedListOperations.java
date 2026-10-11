import java.util.Scanner;

public class LinkedListOperations {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    private Node head = null;

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");
            int ch = Main.getValidInt(sc);

            switch (ch) {
                case 1 -> { System.out.print("Enter value to insert: "); insert(Main.getValidInt(sc)); }
                case 2 -> { System.out.print("Enter value to delete: "); delete(Main.getValidInt(sc)); }
                case 3 -> { System.out.print("Enter value to search: "); search(Main.getValidInt(sc)); }
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println(val + " inserted.");
    }

    public void delete(int val) {
        if (head == null) { System.out.println("List is empty!"); return; }
        if (head.data == val) { head = head.next; System.out.println(val + " deleted."); return; }
        Node temp = head;
        while (temp.next != null && temp.next.data != val) temp = temp.next;
        if (temp.next == null) System.out.println(val + " not found!");
        else { temp.next = temp.next.next; System.out.println(val + " deleted."); }
    }

    public void search(int val) {
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == val) { System.out.println(val + " found at position " + pos); return; }
            temp = temp.next;
            pos++;
        }
        System.out.println(val + " not found!");
    }

    public void display() {
        if (head == null) { System.out.println("List is empty!"); return; }
        System.out.print("Linked List: ");
        Node temp = head;
        while (temp != null) { System.out.print(temp.data + " -> "); temp = temp.next; }
        System.out.println("null");
    }
}