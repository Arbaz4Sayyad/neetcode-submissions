class Solution {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> res = new ArrayList<>();

        backtrack(0, res, board);

        return res;
    }

    private void backtrack(int col, List<List<String>> res, char[][] board) {

        int n = board.length;

        if(col == n) {
            constructRes(board, res);
            return;
        }

        for(int row = 0; row < n; row++) {

            if(isSafe(board, row, col)) {

                board[row][col] = 'Q';

                backtrack(col + 1, res, board);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int r, int c) {

        // same row
        for(int col = 0; col < c; col++) {
            if(board[r][col] == 'Q') {
                return false;
            }
        }

        // upper-left diagonal
        for(int row = r - 1, col = c - 1;
            row >= 0 && col >= 0;
            row--, col--) {

            if(board[row][col] == 'Q') {
                return false;
            }
        }

        // lower-left diagonal
        for(int row = r + 1, col = c - 1;
            row < board.length && col >= 0;
            row++, col--) {

            if(board[row][col] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void constructRes(char[][] board, List<List<String>> res) {

        List<String> current = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            current.add(new String(board[i]));
        }

        res.add(current);
    }
}