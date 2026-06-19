class Solution {

    public List<List<String>> solveNQueens(int n) {

        // Initialize chess board with '.'
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<>();

        // Start placing queens from column 0
        backtrack(0, result, board);

        return result;
    }

    private void backtrack(int col, List<List<String>> result, char[][] board) {

        int n = board.length;

        // Base Case:
        // All columns have been processed successfully
        if (col == n) {
            constructResult(board, result);
            return;
        }

        // Try placing queen in every row of current column
        for (int row = 0; row < n; row++) {

            // Check whether current position is safe
            if (isSafe(board, row, col)) {

                // Choose
                board[row][col] = 'Q';

                // Explore next column
                backtrack(col + 1, result, board);

                // Undo choice (Backtrack)
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

        // No queen can attack this position
        return true;
    }

    private void constructResult(char[][] board,
                                 List<List<String>> result) {

        List<String> currentBoard = new ArrayList<>();

        // Convert each row of board into String
        for (int i = 0; i < board.length; i++) {
            currentBoard.add(new String(board[i]));
        }

        // Store one valid configuration
        result.add(currentBoard);
    }
}