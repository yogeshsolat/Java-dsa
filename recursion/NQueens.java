/**
 * NQueens Problem - Backtracking Approach
 *
 * Story (Sumit Sir style):
 * We have an empty chess board.
 * We go row by row like a disciplined student in an exam hall.
 * In every row we try to place a queen in each column.
 * But before placing → we ask: "Is it safe?"
 *
 * Safe means:
 * 1. No queen in the same column above
 * 2. No queen in left diagonal above
 * 3. No queen in right diagonal above
 *
 * If safe:
 *   → Place queen
 *   → Go to next row (recursion)
 *   → After coming back, remove queen (backtracking)
 *
 * When row == n → All queens are placed → Print the answer.
 */
public class NQueens {

    /**
     * Entry point.
     * Creates an empty chess board and starts the recursive placement.
     */
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n][n];

        // qsf = queen so far (stores positions like "row-col")
        printNQueens(arr, "", 0);
    }

    /**
     * Recursive function to place queens row by row.
     *
     * @param chess current state of the chess board
     * @param qsf   queen so far → stores positions of placed queens
     * @param row   current row where we are trying to place a queen
     */
    public static void printNQueens(int[][] chess, String qsf, int row) {

        // Base case → All rows processed → All queens placed
        if (row == chess.length) {
            System.out.println(qsf);
            return;
        }

        // Try placing queen in every column of the current row
        for (int col = 0; col < chess.length; col++) {

            // Check if it is safe to place queen at (row, col)
            if (isItsSafePlaceForQueen(chess, row, col)) {

                // Place queen
                chess[row][col] = 1;

                // Move to next row
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);

                // Backtrack → remove queen and try next column
                chess[row][col] = 0;
            }
        }
    }

    /**
     * Checks whether placing a queen at (row, col) is safe or not.
     *
     * We only check above rows because queens are placed row by row from top to bottom.
     *
     * @param chess chess board
     * @param row   target row
     * @param col   target column
     * @return true if safe, false otherwise
     */
    public static boolean isItsSafePlaceForQueen(int[][] chess, int row, int col) {

        // 1️⃣ Check vertical up
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // 2️⃣ Check left diagonal up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // 3️⃣ Check right diagonal up
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // No conflicts → safe to place
        return true;
    }
}