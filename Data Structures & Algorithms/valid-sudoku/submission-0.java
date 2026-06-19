class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int row = 0; row < 9; row++) {

            for(int col = 0; col < 9; col++) {

                if(board[row][col] != '.') {

                    char digit = board[row][col];

                    // Temporarily remove current digit
                    board[row][col] = '.';

                    if(!isPlacementPossible(digit, board, row, col)) {
                        return false;
                    }

                    // Restore digit
                    board[row][col] = digit;
                }
            }
        }

        return true;
    }

    private boolean isPlacementPossible(char digit, char[][] board, int row, int col) {

        for(int j = 0; j < 9; j++) {

            // Check row
            if(board[row][j] == digit) {
                return false;
            }

            // Check column
            if(board[j][col] == digit) {
                return false;
            }

            // Check 3x3 box
            int r = 3 * (row / 3) + (j / 3);
            int c = 3 * (col / 3) + (j % 3);

            if(board[r][c] == digit) {
                return false;
            }
        }

        return true;
    }
}