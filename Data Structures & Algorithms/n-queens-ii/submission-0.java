class Solution {

    // Variable to store total number of valid solutions
    private int count = 0;

    public int totalNQueens(int n) {

        // Initialize chess board with '.'
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens from column 0
        backtrack(0, board);

        return count;
    }

    private void backtrack(int col, char[][] board) {

        int n = board.length;

        // Base Case:
        // All columns are processed successfully,
        // which means one valid arrangement is found.
        if (col == n) {
            count++;
            return;
        }

        // Try placing queen in every row of current column
        for (int row = 0; row < n; row++) {

            // Check whether current position is safe
            if (isSafe(board, row, col)) {

                // Choose
                board[row][col] = 'Q';

                // Explore next column
                backtrack(col + 1, board);

                // Undo choice (Backtracking)
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {

        // Check left side of current row
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int r = row - 1, c = col - 1;
             r >= 0 && c >= 0;
             r--, c--) {

            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower-left diagonal
        for (int r = row + 1, c = col - 1;
             r < board.length && c >= 0;
             r++, c--) {

            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Position is safe
        return true;
    }
}