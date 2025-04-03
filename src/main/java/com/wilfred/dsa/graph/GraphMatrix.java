package com.wilfred.dsa.graph;

public class GraphMatrix {

    public void printGraph(int[][] graph) {
        for (int[] row : graph) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void addEdge(int[][] graph, int i, int j) {
        graph[i][j] = 1;
        graph[j][i] = 1;// graph is undirected
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = new int[V][V];
        GraphMatrix graphMatrix = new GraphMatrix();
        graphMatrix.addEdge(graph, 0, 1);
        graphMatrix.addEdge(graph, 0, 2);
        graphMatrix.addEdge(graph, 1, 2);
        graphMatrix.addEdge(graph, 2, 3);
        graphMatrix.printGraph(graph);
    }
}
