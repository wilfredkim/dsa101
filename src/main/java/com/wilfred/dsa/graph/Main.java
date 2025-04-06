package com.wilfred.dsa.graph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.printGraph();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        graph.printGraph();
        graph.removeEdge("A", "B");
        graph.printGraph();
        System.out.println("Graph 2::::::::::::::::::::");

        Graph graph2 = new Graph();
        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");
        graph2.addEdge("A", "B");
        graph2.addEdge("A", "C");
        graph2.addEdge("C", "D");
        graph2.addEdge("B", "D");
        graph2.addEdge("D", "A");
        graph2.printGraph();
        graph2.removeVertex("D");
        graph2.printGraph();

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}};
        for (int[] e : edges) {
            graph2.addEdge(adj, e[0], e[1]);
        }
        ArrayList<Integer> res = graph2.DFS(adj);
        System.out.println("DFS:::::::::::: " + res);

        int vertices = 4;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 3}};
        System.out.println("isCyclic:::::::::::::::::::::::" + graph2.isCyclic(vertices, edges2));

    }
}
