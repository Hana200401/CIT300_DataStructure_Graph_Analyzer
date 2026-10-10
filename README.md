# CIT300 Data Structure and Graph Analyzer

A console-based Java project for practicing common data structures, searching
algorithms, and graph traversal.

## Requirements

- Java Development Kit (JDK) 8 or newer

## Project structure

```text
CIT300_Project/
├── src/
│   ├── Main.java
│   ├── ArrayOperations.java
│   ├── SearchingOperations.java
│   ├── StackOperations.java
│   ├── QueueOperations.java
│   ├── LinkedListOperations.java
│   ├── GraphOperations.java
│   └── PerformanceComparison.java
├── .gitignore
└── README.md
```

## Compile and run

From the project root, compile the source files and run the main menu:

```sh
javac -d out src/*.java
java -cp out Main
```

On Windows Command Prompt, the equivalent compile command is:

```bat
javac -d out src\*.java
java -cp out Main
```

## Features

- Create, update, display, and sort integer arrays
- Search for values linearly and with binary search (on a sorted copy)
- Perform push, pop, peek, and display operations on a stack
- Perform enqueue, dequeue, peek, and display operations on a queue
- Insert, remove, search, and display linked-list values
- Build an undirected graph and display its adjacency list
- Traverse a graph with breadth-first search (BFS) and depth-first search (DFS)
- Compare linear and binary search timings on generated sorted data
