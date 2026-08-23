class NumMatrix {

    // prefix[i][j] stores the sum of the rectangle
    // from (0, 0) to (i-1, j-1)
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Extra row and column to avoid boundary checks
        prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                // Current cell
                int current = matrix[i - 1][j - 1];

                // Prefix sum formula:
                //
                // prefix[i][j]
                // = current
                // + rectangle above
                // + rectangle left
                // - overlapping rectangle
                prefix[i][j] =
                        current
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        // Convert original coordinates to prefix coordinates
        row1++;
        col1++;
        row2++;
        col2++;

        // Inclusion-exclusion formula
        //
        // Total rectangle
        // - area above
        // - area to the left
        // + overlapping area
        return prefix[row2][col2]
                - prefix[row1 - 1][col2]
                - prefix[row2][col1 - 1]
                + prefix[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


