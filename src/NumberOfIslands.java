/**
 * 200. Number of Islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    markIsland(grid, i, j, visited);
                    result++;
                }
            }
        }

        return result;
    }

    private void markIsland(char[][] grid, int i, int j, int[][] visited) {
        if (grid[i][j] == '0' || visited[i][j] != 0) return;
        visited[i][j] = 1;
        // up
        if (i > 0) markIsland(grid, i - 1, j, visited);
        // down
        if (i < grid.length - 1) markIsland(grid, i + 1, j, visited);
        // left
        if (j > 0) markIsland(grid, i, j - 1, visited);
        // right
        if (j < grid[0].length - 1) markIsland(grid, i, j + 1, visited); 
    }
}