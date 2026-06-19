class Solution {

    public List<List<String>> partition(String s) {

        // Stores all valid palindrome partitions
        List<List<String>> res = new ArrayList<>();

        // Stores current partition path
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, res);

        return res;
    }

    private void backtrack(String s, int partIndex, List<String> current, List<List<String>> res) {

        int n = s.length();

        // Base Case:
        // Entire string has been partitioned
        if (partIndex == n) {
            res.add(new ArrayList<>(current));
            return;
        }

        // Try every possible ending index
        for (int end = partIndex; end < n; end++) {

            // Consider substring s[partIndex...end]
            if (isPalindrome(s, partIndex, end)) {

                // Choose
                current.add(s.substring(partIndex, end + 1));

                // Explore remaining part of string
                backtrack(s, end + 1, current, res);

                // Unchoose (Backtrack)
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        // Two-pointer palindrome check
        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}