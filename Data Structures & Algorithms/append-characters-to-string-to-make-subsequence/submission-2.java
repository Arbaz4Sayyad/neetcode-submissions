class Solution {

    /*
     * Append Characters to String to Make Subsequence
     * ------------------------------------------------
     *
     * Given two strings s and t,
     * return the minimum number of characters that need
     * to be appended to the end of s so that t becomes
     * a subsequence of s.
     *
     * Approach: Two Pointers
     *
     * TC: O(N + M)
     * SC: O(1)
     *
     * Idea:
     * Try to match as many characters of t as possible
     * within s.
     *
     * If we successfully match j characters of t,
     * then the remaining characters:
     *
     * t.length() - j
     *
     * must be appended to s.
     */
    public int appendCharacters(String s, String t) {

        // Pointer for string s
        int i = 0;

        // Pointer for string t
        int j = 0;

        /*
         * Traverse both strings.
         *
         * Whenever characters match,
         * move both pointers.
         *
         * Otherwise move only i because
         * we're trying to find the current
         * character of t somewhere ahead in s.
         */
        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {

                // Character matched
                i++;
                j++;

            } else {

                // Skip current character in s
                i++;
            }
        }

        /*
         * j represents how many characters of t
         * have already been matched.
         *
         * Remaining characters must be appended.
         */
        return t.length() - j;
    }
}