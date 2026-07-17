class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(1, n, k, current, res);

        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> res) {
        // Base case:
        // If current combination has k elements, store it.
        if (current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        // Try every possible number from 'start' to n
        for (int i = start; i <= n; i++) {

            // Choose
            current.add(i);

            // Explore further with next number
            backtrack(i + 1, n, k, current, res);

            // Undo the choice (Backtrack)
            current.remove(current.size() - 1);
        }
    }
} 