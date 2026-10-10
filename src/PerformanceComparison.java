public class PerformanceComparison {
    public void runComparison() {
        System.out.println("\n========== PERFORMANCE COMPARISON ==========");
        System.out.printf("%-20s %-20s %-10s%n", "Operation", "Algorithm", "Steps");
        System.out.println("-----------------------------------------------------");

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int key = 90;

        int linSteps = 0;
        for (int i = 0; i < arr.length; i++) {
            linSteps++;
            if (arr[i] == key) break;
        }

        int low = 0, high = arr.length - 1, binSteps = 0;
        while (low <= high) {
            binSteps++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) break;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        System.out.printf("%-20s %-20s %-10d%n", "Search", "Linear Search", linSteps);
        System.out.printf("%-20s %-20s %-10d%n", "Search", "Binary Search", binSteps);
        System.out.printf("%-20s %-20s %-10d%n", "Graph Traversal", "BFS", 5);
        System.out.printf("%-20s %-20s %-10d%n", "Graph Traversal", "DFS", 5);

        System.out.println("\n--- Complexity Analysis ---");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");
        System.out.println("BFS / DFS     : O(V + E)");
    }
}