package com.wilfred.dsa.algorithms.sorts.dijkstra;

import java.util.*;

public class Dijikstra {

    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        // Build adjacency list with weights
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];
            adjList.get(source).add(new int[]{target, weight});
            adjList.get(target).add(new int[]{source, weight}); // remove if graph is directed
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int currDist = current[1];

            if (currDist > distances[node]) continue;

            for (int[] neighbor : adjList.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currDist + weight;

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    queue.offer(new int[]{nextNode, newDist});
                }
            }
        }

        return distances;
    }
    // code here


    public int[] dijkstra2(int V, int[][] edges, int src) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];
            adjList.get(source).add(new int[]{target, weight});
            adjList.get(target).add(new int[]{source, weight});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int currentDist = current[1];
            if (currentDist > distances[node]) continue;

            for (int[] neigbor : adjList.get(node)) {
                int nextNode = neigbor[0];
                int weight = neigbor[1];
                int newDist = currentDist + weight;
                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    queue.offer(new int[]{nextNode, newDist});
                }
            }
        }
        return distances;


    }

}
