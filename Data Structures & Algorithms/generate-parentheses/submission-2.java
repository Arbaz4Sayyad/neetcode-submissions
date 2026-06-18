class Solution {

    /*
     * Generate Parentheses
     * --------------------
     *
     * Given n pairs of parentheses,
     * generate all valid combinations.
     *
     * Example:
     * n = 3
     *
     * Output:
     * ["((()))","(()())","(())()","()(())","()()()"]
     *
     * Approach:
     * Backtracking
     *
     * TC: O(4^N / √N)  (Catalan Number)
     * SC: O(N)         (Recursion Stack)
     */
    public List<String> generateParenthesis(int n) {

        List<String> output = new ArrayList<>();

        // Start with an empty string
        backtrack(
            new StringBuilder(),
            0,      // open brackets used
            0,      // close brackets used
            n,
            output
        );

        return output;
    }

    /*
     * current -> current parenthesis string
     * open    -> number of '(' used
     * close   -> number of ')' used
     */
    public void backtrack(StringBuilder current, int open, int close, int n, List<String> output) {

        /*
         * Base Case
         *
         * If we have used all n opening
         * and all n closing brackets,
         * then a valid combination is formed.
         */
        if (open == n && close == n) {
            output.add(current.toString());
            return;
        }

        /*
         * Choice 1:
         * Add '('
         *
         * We can add '(' only if
         * we still have opening brackets left.
         */
        if (open < n) {

            current.append('(');

            backtrack(current, open + 1, close, n, output);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }

        /*
         * Choice 2:
         * Add ')'
         *
         * We can add ')' only when:
         *
         * close < open
         *
         * meaning there exists an unmatched '('
         * available to close.
         */
        if (close < open) {

            current.append(')');

            backtrack(current, open, close + 1, n, output);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}
