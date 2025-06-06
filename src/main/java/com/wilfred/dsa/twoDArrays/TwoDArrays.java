package com.wilfred.dsa.twoDArrays;

import java.util.*;

public class TwoDArrays {

    static int[][] directions = new int[][]{
            {-1, 0},//up
            {0, 1},//right
            {1, 0},//down
            {0, -1},//left
    };

    public static List<Integer> traversalDFS(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] seen = new boolean[rows][cols];
        List<Integer> values = new ArrayList<>();
        dfs(matrix, 0, 0, seen, values);
        return values;
    }

    private static void dfs(int[][] matrix, int row, int col, boolean[][] seen, List<Integer> values) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || seen[row][col]) {
            return;
        }

        seen[row][col] = true;
        values.add(matrix[row][col]);

        for (int[] dir : directions) {
            dfs(matrix, row + dir[0], col + dir[1], seen, values);
        }
    }

    public static List<Integer> traversalBFS(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] seen = new boolean[rows][cols];
        List<Integer> values = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        // Start from top-left cell
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int row = currentPos[0];
            int col = currentPos[1];

            // Check bounds and whether we've seen this cell before
            if (row < 0 || row >= rows || col < 0 || col >= cols || seen[row][col]) {
                continue;
            }

            seen[row][col] = true;
            values.add(matrix[row][col]);

            for (int[] dir : directions) {
                queue.offer(new int[]{row + dir[0], col + dir[1]});
            }
        }

        return values;

    }

    public int numIslands(char[][] grid) {
        int countIsands = 0;
        int rows = grid.length;
        if (rows == 0)
            return 0;

        int cols = grid[0].length;

        // Directions: up, down, left, right
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    countIsands++;
                    grid[row][col] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});
                    while (!queue.isEmpty()) {
                        int[] currentPos = queue.poll();
                        int rowCurrent = currentPos[0];
                        int colCurrent = currentPos[1];

                        for (int[] dir : directions) {
                            int nextRow = rowCurrent + dir[0];
                            int nextCol = colCurrent + dir[1];
                            // Check bounds and whether we've seen this cell before
                            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                                continue;
                            }
                            if (grid[nextRow][nextCol] == '1') {
                                queue.offer(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return countIsands;
    }


    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;
        int rowsLen = grid.length;
        int colsLen = grid[0].length;
        for (int row = 0; row < rowsLen; row++) {
            for (int col = 0; col < colsLen; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfsCountIslands(grid, row, col, directions);

                }
            }
        }
        return count;
    }


    private void dfsCountIslands(char[][] matrix, int row, int col, int[][] directions) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return;
        if (matrix[row][col] != '1') return;

        matrix[row][col] = '0';

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfsCountIslands(matrix, newRow, newCol, directions);
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null)
            return 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        final int FRESH_ORANGE = 1;
        final int ROTTEN_ORANGE = 2;
        Queue<int[]> queue = new LinkedList<>();
        int freshOrangesCount = 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == ROTTEN_ORANGE) {
                    queue.offer(new int[]{row, col});
                }
                if (grid[row][col] == FRESH_ORANGE) {
                    freshOrangesCount++;
                }

            }
        }
        int queueSize = queue.size();
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (queueSize == 0) {
                minutes++;
                queueSize = queue.size();
            }
            int[] currentOrange = queue.poll();
            queueSize--;
            int currentRowOrange = currentOrange[0];
            int currentColOrange = currentOrange[1];
            for (int[] dir : directions) {
                int nextRowOrange = currentRowOrange + dir[0];
                int nextColOrange = currentColOrange + dir[1];
                if (nextRowOrange < 0 || nextRowOrange >= rowLen || nextColOrange < 0 || nextColOrange >= colLen) {
                    continue;
                }
                if (grid[nextRowOrange][nextColOrange] == FRESH_ORANGE) {
                    grid[nextRowOrange][nextColOrange] = ROTTEN_ORANGE;
                    freshOrangesCount--;
                    queue.offer(new int[]{nextRowOrange, nextColOrange});
                }
            }

        }
        if (freshOrangesCount > 0)
            return -1;
        return minutes;

    }


}
