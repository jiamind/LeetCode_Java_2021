import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 */
public class PacificAtlanticWaterFlow {
    static int REACH_PO = 2;
    static int REACH_AO = 1;
    static int REACH_BOTH = 3;
    static int REACH_NONE = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] reachability = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                getRechability(i, j, heights, visited, reachability);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < reachability.length; i++) {
            for (int j = 0; j < reachability[0].length; j++) {
                if (reachability[i][j] == REACH_BOTH) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private int getRechability(int r, int c, int[][] heights, boolean[][] visited, int[][] reachability) {
        
        if (reachability[r][c] == REACH_BOTH) return REACH_BOTH;

        int result = REACH_NONE;

        if (r == 0 || c == 0) {
            result |= REACH_PO;
        }

        if (r == heights.length - 1 || c == heights[0].length - 1) {
            result |= REACH_AO;
        }

        visited[r][c] = true;

        // Go up
        if (r != 0 && !visited[r-1][c] && heights[r-1][c] <= heights[r][c]) {
            result |= reachability[r-1][c];
        }

        // Go down
        if (r != heights.length - 1 && !visited[r+1][c] && heights[r+1][c] <= heights[r][c]) {
            result |= getRechability(r+1, c, heights, visited, reachability);
        }

        // Go left
        if (c != 0 && !visited[r][c-1] && heights[r][c-1] <= heights[r][c]) {
            result |= reachability[r][c-1];
        }

        // Go right
        if (c != heights[0].length - 1 && !visited[r][c+1] && heights[r][c+1] <= heights[r][c]) {
            result |= getRechability(r, c+1, heights, visited, reachability);
        }

        visited[r][c] = false;

        reachability[r][c] |= result;

        return reachability[r][c];
    }
}
