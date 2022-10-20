import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int numOfOranges = 0;
        int numOfRottenOranges = 0;

        Queue<int[]> rottenOranges = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numOfOranges++;
                } else if (grid[i][j] == 2) {
                    numOfOranges++;
                    numOfRottenOranges++;
                    rottenOranges.add(new int[]{i,j});
                }
            }
        }

        while(!rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            for(int i = 0; i < size; i++) {
                int[] rottenOrange = rottenOranges.remove();
                int r = rottenOrange[0];
                int c = rottenOrange[1];
                // up
                if (r > 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    numOfRottenOranges++;
                    rottenOranges.add(new int[]{r-1,c});
                }
                // down
                if (r < grid.length - 1 && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    numOfRottenOranges++;
                    rottenOranges.add(new int[]{r+1,c});
                }
                // left
                if (c > 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    numOfRottenOranges++;
                    rottenOranges.add(new int[]{r,c-1});
                }
                // right
                if (c < grid[0].length - 1&& grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    numOfRottenOranges++;
                    rottenOranges.add(new int[]{r,c+1});
                }
            }
            // increment by one minute only when needed (i.e. there's one or more newly rotten oranges)
            if (rottenOranges.size() > 0) minutes++;
        }

        return numOfOranges == numOfRottenOranges ? minutes : -1;
    }
}
