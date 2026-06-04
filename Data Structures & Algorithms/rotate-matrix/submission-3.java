class Solution {
    public void rotate(int[][] matrix) {
        // 1. transpose matrix
        // swap matrix[i][j] = matrix[j][i]
        // 2. reverse all rows

        int n = matrix.length;
    
        for(int row = 0; row < n; row++){
            for(int col = row+1; col < n; col++){ // swap diagonally
                int  temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // reverse all rows
        for(int row = 0; row < n; row++){
            int startCol = 0;
            int endCol = n-1;

            while(startCol <= endCol){
                // swap matrix[row][startCol] = matrix[row][endCol]
                int temp = matrix[row][startCol];
                matrix[row][startCol] = matrix[row][endCol];
                matrix[row][endCol] = temp;

                startCol++;
                endCol--;
            }
        }
    }
}
