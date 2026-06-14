class Solution {

    /*
     * Approach 1: Brute Force
     * -----------------------
     *
     * Traverse every cell in the matrix.
     *
     * TC: O(M * N)
     * SC: O(1)
     */
    // public boolean searchMatrix(int[][] matrix, int target) {
    //
    //     for (int row = 0; row < matrix.length; row++) {
    //         for (int col = 0; col < matrix[0].length; col++) {
    //
    //             if (matrix[row][col] == target) {
    //                 return true;
    //             }
    //         }
    //     }
    //
    //     return false;
    // }

    /*
     * Approach 2: Binary Search
     * -------------------------
     *
     * TC: O(log(M * N))
     * SC: O(1)
     *
     * This approach works ONLY because:
     *
     * 1. Each row is sorted.
     * 2. First element of a row is greater than
     *    the last element of the previous row.
     *
     * Example:
     *
     * 1  3  5  7
     * 10 11 16 20
     * 23 30 34 60
     *
     * If flattened:
     *
     * [1,3,5,7,10,11,16,20,23,30,34,60]
     *
     * The entire matrix behaves like one sorted array.
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        /*
         * Total elements if matrix were flattened.
         */
        int n = totalRows * totalCols;

        // Binary Search range
        int start = 0;
        int end = n - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * Convert 1D index into 2D coordinates.
             *
             * Example:
             * totalCols = 4
             *
             * mid = 6
             *
             * row = 6 / 4 = 1
             * col = 6 % 4 = 2
             *
             * matrix[1][2]
             */
            int rowIndex = mid / totalCols;
            int colIndex = mid % totalCols;

            int value = matrix[rowIndex][colIndex];

            if (value == target) {
                return true;
            }

            /*
             * Target lies in left half.
             */
            else if (value > target) {
                end = mid - 1;
            }

            /*
             * Target lies in right half.
             */
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}