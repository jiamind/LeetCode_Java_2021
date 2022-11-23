/**
 * 289. Game of Life
 */
public class GameOfLife {
    private static final int DEAD_CELL = 0;
    private static final int LIVE_CELL = 1;
    private static final int DEAD_TO_LIVE_CELL = 3;
    private static final int LIVE_TO_DEAD_CELL = 4;

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                nextState(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == DEAD_TO_LIVE_CELL) {
                    board[i][j] = LIVE_CELL;
                } else if (board[i][j] == LIVE_TO_DEAD_CELL) {
                    board[i][j] = DEAD_CELL;
                }
            }
        }
    }

    private void nextState(int[][] board, int i, int j) {
        if (board[i][j] == DEAD_CELL) {
            if (countNeighborLiveCells(board, i, j) == 3) {
                board[i][j] = DEAD_TO_LIVE_CELL;
            }
        } else if (board[i][j] == LIVE_CELL) {
            int liveNeighbors = countNeighborLiveCells(board, i, j);
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                board[i][j] = LIVE_TO_DEAD_CELL;
            }
        }
    }

    private int countNeighborLiveCells(int[][] board, int i, int j) {
        int liveCount = 0;
        if (i > 0 && (board[i-1][j] == LIVE_CELL || board[i-1][j] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (i < board.length - 1 && (board[i+1][j] == LIVE_CELL || board[i+1][j] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (j > 0 && (board[i][j-1] == LIVE_CELL || board[i][j-1] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (j < board[0].length - 1 && (board[i][j+1] == LIVE_CELL || board[i][j+1] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (i > 0 && j > 0 && (board[i-1][j-1] == LIVE_CELL || board[i-1][j-1] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (i > 0 && j < board[0].length - 1 && (board[i-1][j+1] == LIVE_CELL || board[i-1][j+1] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (i < board.length - 1 && j > 0 && (board[i+1][j-1] == LIVE_CELL || board[i+1][j-1] == LIVE_TO_DEAD_CELL))
            liveCount++;
        if (i < board.length - 1 && j < board[0].length - 1 && (board[i+1][j+1] == LIVE_CELL || board[i+1][j+1] == LIVE_TO_DEAD_CELL))
            liveCount++;

        return liveCount;
    }
}
