class Solution {
    public int[][] transpose(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0){
            return new int[0][0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] output = new int[n][m];

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                output[col][row] = matrix[row][col];
            }
        } 
        return output;
    }
}