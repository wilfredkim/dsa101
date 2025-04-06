package com.wilfred.dsa.graph;

import java.util.*;

public class Graph {
    //adjacency list!!!
    HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertexOne, String vertexTwo) {
        if (adjList.get(vertexOne) != null && adjList.get(vertexTwo) != null) {
            adjList.get(vertexOne).add(vertexTwo);
            adjList.get(vertexTwo).add(vertexOne);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertexOne, String vertexTwo) {
        if (adjList.get(vertexOne) != null && adjList.get(vertexTwo) != null) {
            adjList.get(vertexOne).remove(vertexTwo);
            adjList.get(vertexTwo).remove(vertexOne);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }


    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();
        ArrayList<Integer> results = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        //start node!
        int source = 0;
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            results.add(current);
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }

            }
        }
        return results;

    }


    public static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        dfsRec(adj, visited, 0, res);
        return res;
    }

    private static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> res) {
        visited[s] = true;
        res.add(s);

        // Recursively visit all adjacent vertices that are
        // not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i, res);
            }
        }
    }

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int s,
                        int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }


    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        //adding edges!!
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        boolean[] recurrentStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(adj, i, visited, recurrentStack)) {
                return true;
            }
        }
        return false;

    }

    private boolean isCyclicUtil(List<List<Integer>> adj, int i, boolean[] visited, boolean[] recStack) {
        // Check for valid node index
        if (adj == null || i < 0 || i >= adj.size()) {
            return false;
        }

        // If the current node is already in the recursion stack, a cycle is detected
        if (recStack[i]) {
            return true;
        }

        // If already visited and not in recStack, it's not part of a cycle
        if (visited[i]) {
            return false;
        }

        // Mark the current node as visited and add it to the recursion stack
        visited[i] = true;
        recStack[i] = true;

        for (int x : adj.get(i)) {
            if (x < 0 || x >= adj.size()) {
                continue; // Ignore invalid indices
            }
            if (isCyclicUtil(adj, x, visited, recStack)) {
                return true;
            }
        }

        // Backtrack: remove the vertex from the recursion stack
        recStack[i] = false;
        return false;
    }

    public boolean isCycleUndirected(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] && isCyclicUndirectedUtil(adj, i, visited, -1)) {
                return true;
            }
        }
        return false;

    }

    private boolean isCyclicUndirectedUtil(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent) {
        visited[i] = true;
        for (int x : adj.get(i)) {
            if (!visited[x]) {
                if (isCyclicUndirectedUtil(adj, x, visited, i)) {
                    return true;
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            if (dfs(i, 1, n, visited, edges)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int node, int count, int n, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        if (count == n) {
            return true;
        }
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, count + 1, n, visited, adj)) {
                    return true;
                }
            }
        }
        visited[node] = false;
        return false;
    }

    public int orangesRotting(int[][] mat) {
        // Code here

        int n = mat.length;
        int m = mat[0].length;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    dfs(mat, i, j, 2);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if orange is fresh
                if (mat[i][j] == 1)
                    return -1;

                time = Math.max(time, mat[i][j] - 2);
            }
        }
        return time;

    }

    // function to perform dfs and find fresh orange
    static void dfs(int[][] mat, int i, int j, int time) {
        int n = mat.length;
        int m = mat[0].length;

        // update minimum time
        mat[i][j] = time;

        // all four directions
        int[][] directions
                = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // change 4-directionally connected cells
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            // if cell is in the matrix and
            // the orange is fresh
            if (isSafe(x, y, n, m)
                    && (mat[x][y] == 1
                    || mat[x][y] > time + 1)) {
                dfs(mat, x, y, time + 1);
            }
        }
    }

    static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
}
