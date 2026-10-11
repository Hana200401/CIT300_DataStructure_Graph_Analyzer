import java.util.*;

public class GraphOperations {
    private Map<String, List<String>> adjList = new LinkedHashMap<>();

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- GRAPH OPERATIONS ---");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter choice: ");
            int ch = Main.getValidInt(sc);
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter vertex name: ");
                    addVertex(sc.nextLine().trim());
                }
                case 2 -> {
                    System.out.print("Enter source vertex: ");
                    String src = sc.nextLine().trim();
                    System.out.print("Enter destination vertex: ");
                    String dest = sc.nextLine().trim();
                    addEdge(src, dest);
                }
                case 3 -> displayGraph();
                case 4 -> {
                    System.out.print("Enter start vertex for BFS: ");
                    bfs(sc.nextLine().trim());
                }
                case 5 -> {
                    System.out.print("Enter start vertex for DFS: ");
                    dfs(sc.nextLine().trim());
                }
                case 6 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void addVertex(String v) {
        if (adjList.containsKey(v)) {
            System.out.println("Vertex already exists!");
            return;
        }
        adjList.put(v, new ArrayList<>());
        System.out.println("Vertex " + v + " added.");
    }

    public void addEdge(String src, String dest) {
        if (!adjList.containsKey(src) || !adjList.containsKey(dest)) {
            System.out.println("Both vertices must exist first!");
            return;
        }
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
        System.out.println("Edge added: " + src + " <-> " + dest);
    }

    public void displayGraph() {
        if (adjList.isEmpty()) {
            System.out.println("Graph is empty!");
            return;
        }
        System.out.println("\nGraph Adjacency List:");
        for (Map.Entry<String, List<String>> e : adjList.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start vertex not found!");
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        int steps = 0;
        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            String node = q.poll();
            System.out.print(node + " ");
            steps++;
            for (String n : adjList.get(node)) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    q.add(n);
                }
            }
        }
        System.out.println("\nSteps = " + steps + " | Complexity = O(V + E)");
    }

    public void dfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start vertex not found!");
            return;
        }
        Set<String> visited = new HashSet<>();
        System.out.print("DFS: ");
        int[] steps = {0};
        dfsRec(start, visited, steps);
        System.out.println("\nSteps = " + steps[0] + " | Complexity = O(V + E)");
    }

    private void dfsRec(String node, Set<String> visited, int[] steps) {
        visited.add(node);
        System.out.print(node + " ");
        steps[0]++;
        for (String n : adjList.get(node)) {
            if (!visited.contains(n)) dfsRec(n, visited, steps);
        }
    }
}