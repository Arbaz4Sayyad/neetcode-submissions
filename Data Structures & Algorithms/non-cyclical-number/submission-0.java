class Solution {

    /*
     * Happy Number
     * ------------
     *
     * TC: O(log N)
     * SC: O(log N)
     *
     * Store previously seen numbers in a HashSet.
     * If a number repeats, we've entered a cycle.
     */
    public boolean isHappy(int n) {

        // Stores all previously seen numbers
        Set<Integer> set = new HashSet<>();

        while (n != 1) {

            /*
             * If n is already present,
             * we've encountered a cycle.
             */
            if (set.contains(n)) {
                return false;
            }

            // Mark current number as visited
            set.add(n);

            // Generate next number
            n = getSumOfSquares(n);
        }

        // Reached 1 => Happy Number
        return true;
    }

    /*
     * Returns sum of squares of digits
     *
     * Example:
     * 19
     * => 1² + 9²
     * => 82
     */
    private int getSumOfSquares(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n /= 10;
        }

        return sum;
    }
}