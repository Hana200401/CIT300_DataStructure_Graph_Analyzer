import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GraphOperations {
    private GraphOperations() {
    }

    public static void run(Scanner scanner) {
        Map<Integer, Set<Integer>> graph = new LinkedHashMap<Integer, Set<Integer>>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Undirected graph operations ---");
            System.out.println("1. Add vertex");
            System.out.println("2. Add edge");
            System.out.println("3. Display adjacency list");
            System.out.println("4. Breadth-first traversal");
            System.out.println("5. Depth-first traversal");
            System.out.println("0. Back");
            int choice = Main.readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    addVertex(graph, Main.readInt(scanner, "Vertex label: "));
                    break;
                case 2:
                    int from = Main.readInt(scanner, "First vertex: ");
                    int to = Main.readInt(scanner, "Second vertex: ");
                    addEdge(graph, from, to);
                    break;
                case 3:
                    display(graph);
                    break;
                case 4:
                    traverse(graph, Main.readInt(scanner, "Starting vertex: "), false);
                    break;
                case 5:
                    traverse(graph, Main.readInt(scanner, "Starting vertex: "), true);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Please choose a listed option.");
            }
        }
    }

    private static void addVertex(Map<Integer, Set<Integer>> graph, int vertex) {
        graph.putIfAbsent(vertex, new LinkedHashSet<Integer>());
        System.out.println("Vertex " + vertex + " is in the graph.");
    }

    private static void addEdge(Map<Integer, Set<Integer>> graph, int from, int to) {
        addVertex(graph, from);
        addVertex(graph, to);
        graph.get(from).add(to);
        graph.get(to).add(from);
        System.out.println("Added edge " + from + " - " + to + ".");
    }

    private static void display(Map<Integer, Set<Integer>> graph) {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void traverse(Map<Integer, Set<Integer>> graph, int start, boolean depthFirst) {
        if (!graph.containsKey(start)) {
            System.out.println("Starting vertex is not in the graph.");
            return;
        }

        Set<Integer> visited = new LinkedHashSet<Integer>();
        Deque<Integer> pending = new ArrayDeque<Integer>();
        List<Integer> order = new ArrayList<Integer>();
        pending.add(start);

        while (!pending.isEmpty()) {
            int current = depthFirst ? pending.removeLast() : pending.removeFirst();
            if (!visited.add(current)) {
                continue;
            }
            order.add(current);
            List<Integer> neighbors = new ArrayList<Integer>(graph.get(current));
            if (depthFirst) {
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    if (!visited.contains(neighbors.get(i))) {
                        pending.addLast(neighbors.get(i));
                    }
                }
            } else {
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        pending.addLast(neighbor);
                    }
                }
            }
        }

        System.out.println((depthFirst ? "Depth-first" : "Breadth-first")
                + " traversal: " + order);
    }
}
