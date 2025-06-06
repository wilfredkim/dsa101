package com.wilfred.dsa.graph;

import java.util.*;

public class GraphDFS {



    public static void traversalDFS(int vertex, List<List<Integer>> graph, List<Integer> values, boolean[] seen) {
        values.add(vertex);
        seen[vertex] = true;

        List<Integer> connections = graph.get(vertex);
        for (int connection : connections) {
            if (!seen[connection]) {
                traversalDFS(connection, graph, values, seen);
            }
        }
    }
    int V; //Number of Vertices
    LinkedList<Integer>[] adj; // adjacency lists

    GraphDFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<>();

    }

    //To add an edge to graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v’s list.
    }

    // prints all not yet visited vertices reachable from s
    void DFS(int s) {
        // Initially mark all vertices as not visited
        Vector<Boolean> visited = new Vector<>(V);
        for (int i = 0; i < V; i++)
            visited.add(false);

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Push the current source node
        stack.push(s);

        while (!stack.empty()) {
            // Pop a vertex from stack and print it
            s = stack.peek();
            stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if (!visited.get(s)) {
                System.out.print(s + " ");
                visited.set(s, true);
            }

            // Get all adjacent vertices of the popped vertex s
            // If a adjacent has not been visited, then push it
            // to the stack.
            Iterator<Integer> itr = adj[s].iterator();

            while (itr.hasNext()) {
                int v = itr.next();
                if (!visited.get(v))
                    stack.push(v);
            }

        }
    }

    public static void main(String[] args) {
        // Total 5 vertices in graph
        GraphDFS g = new GraphDFS(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }

}
