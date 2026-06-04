class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m-1;
        int startCol = 0;
        int endCol = n-1;

        while(startRow <= endRow && startCol <= endCol){
            // row wise left to right
            for(int col = startCol; col <= endCol; col++){
                output.add(matrix[startRow][col]);
            }
            startRow++;

            // col wise top to bottom
            for(int row = startRow; row <= endRow; row++){
                output.add(matrix[row][endCol]);
            }
            endCol--;

            if (startRow <= endRow) { // check valid: check for startting row
                // row wise right to left
                for(int col = endCol; col >= startCol; col--){
                    output.add(matrix[endRow][col]);
                }
                endRow--;
            }
            
            if (startCol <= endCol) { // check valid: check for startting col
                // col wise bottom to top
                for(int row = endRow; row >= startRow; row--){
                    output.add(matrix[row][startCol]);
                }
                startCol++;
            }
        }
        return output;
    }
}