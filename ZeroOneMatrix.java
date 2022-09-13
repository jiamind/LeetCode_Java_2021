import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        // Safe check
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return null;
        }

        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    result[i][j] = -1;
                }
            }
        }
        
        // BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            if (r > 0 && result[r-1][c] == -1) {
                result[r-1][c] = result[r][c] + 1;
                queue.add(new int[]{r-1, c});
            }

            if (r < result.length - 1 && result[r+1][c] == -1) {
                result[r+1][c] = result[r][c] + 1;
                queue.add(new int[]{r+1, c});
            }

            if (c > 0 && result[r][c-1] == -1) {
                result[r][c-1] = result[r][c] + 1;
                queue.add(new int[]{r, c-1});
            }

            if (c < result[0].length - 1 && result[r][c+1] == -1) {
                result[r][c+1] = result[r][c] + 1;
                queue.add(new int[]{r, c+1});
            }
        }
       

        return result;
    }
}
