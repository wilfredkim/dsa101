package com.wilfred.dsa.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.printGraph();
        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("A","C");
        graph.printGraph();
        graph.removeEdge("A","B");
        graph.printGraph();
        System.out.println("Graph 2::::::::::::::::::::");

        Graph graph2 = new Graph();
        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");
        graph2.addEdge("A","B");
        graph2.addEdge("A","C");
        graph2.addEdge("C","D");
        graph2.addEdge("B","D");
        graph2.addEdge("D","A");
        graph2.printGraph();
        graph2.removeVertex("D");
        graph2.printGraph();


    }
}
