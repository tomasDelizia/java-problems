package com.tomasdelizia.matrix.problem;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private static final Direction[] directions = new Direction[]{
            new Direction(-1, 0), // Up
            new Direction(1, 0), // Down
            new Direction(0, 1), // Right
            new Direction(0, -1), // Left
    };

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;

        int islandCount = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char current = grid[i][j];
                if (current == '1' && !visited[i][j]) {
                    Cell cell = new Cell(i, j);
                    // Traverse the matrix using BFS until there are no island cells to visit.
                    bfs(cell, grid, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void bfs(Cell cell, char[][] grid, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(cell);
        visited[cell.row][cell.col] = true;
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            for (Direction d : directions) {
                Cell toVisit = new Cell(current.row + d.x, current.col + d.y);
                // A valid island cell must be in the grid range, be a 1 (land) and not have been visited.
                boolean isLandCell = toVisit.row < n && toVisit.row >= 0 && toVisit.col < m && toVisit.col >= 0
                        && grid[toVisit.row][toVisit.col] == '1'
                        && !visited[toVisit.row][toVisit.col];
                if (!isLandCell) continue;
                visited[toVisit.row][toVisit.col] = true;
                queue.offer(toVisit);
            }
        }
    }

    record Cell(int row, int col) {}

    record Direction(int x, int y) {}
}
