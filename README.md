# CIT300 Graded Practical Assignment 2
# Data Structure & Graph Analyzer

## Project Description
Java console-based application demonstrating Array, Stack, Queue, Linked List, Searching, and Graph (BFS/DFS) with performance comparison and complexity analysis.

## Group Member Details

| Member | Student Name | Student ID | Assigned Responsibility | Individual Contribution |
|--------|-------------|-----------|------------------------|------------------------|
| Member 1 | AMF. Hana | 23da2-0674 | Array & Searching | Implemented ArrayOperations.java (insert, delete, search, display) and SearchingOperations.java (linear search, binary search, comparison). Tested both modules. |
| Member 2 | IL. Asjatha | 23da2-1088 | Stack & Queue | Implemented StackOperations.java (push, pop, peek, display) and QueueOperations.java (enqueue, dequeue, peek, display). Handled overflow/underflow conditions. |
| Member 3 | MA. Aysha Banu | 23da2-0866 | Linked List & Graph | Implemented LinkedListOperations.java (insert, delete, search, display) and GraphOperations.java (add vertex, add edge, display, BFS, DFS). Tested graph traversal. |
| Member 4 | AM. Safra Julla | 23da2-0527 | Integration & Performance | Implemented Main.java (menu integration), PerformanceComparison.java, input validation. Integrated all modules and tested complete system. |

## Technologies Used
- Java (JDK 17+)
- Console-based UI
- Java Collections Framework (for Graph BFS/DFS)
- Git & GitHub for collaboration

## Main System Features

### Array Operations
- Insert element
- Delete element
- Search element
- Display array

### Stack Operations
- Push
- Pop
- Peek
- Display
- Handles overflow/underflow

### Queue Operations
- Enqueue
- Dequeue
- Peek/Front
- Display
- Handles empty queue

### Linked List Operations
- Insert
- Delete
- Search
- Display

### Searching Operations
- Linear Search (O(n))
- Binary Search (O(log n))
- Compare Both (steps + time)

### Graph Operations
- Add Vertex
- Add Edge
- Display Graph
- BFS Traversal (O(V + E))
- DFS Traversal (O(V + E))

### Performance Comparison
- Linear Search vs Binary Search
- Steps count
- Execution time
- Complexity explanation

## How to Run the Program

### Compile
```bash
javac src/*.java -d out