package com.wilfred.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    static boolean bfs(int start, List<Integer>[] adj, boolean[] visited)
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { start, -1 });
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int node = front[0];
            int parent = front[1];

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[] { neighbor, node });
                }
                // If visited and not the parent, cycle
                // exists
                else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isCycle(int V, int[][] edges)
    {
        // Create adjacency list
        List<Integer>[] adj = constructadj(V, edges);
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    static List<Integer>[] constructadj(int V,
                                        int[][] edges)
    {

        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        return adj;
    }
}
