class Solution {

    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    // index -> current element we are considering
    // currentXor -> XOR of elements selected so far
    private int backtrack(int[] nums, int index, int currentXor) {

        // We have considered all elements.
        // currentXor represents the XOR of one complete subset.
        if (index == nums.length) {
            return currentXor;
        }

        // Choice 1: Include nums[index] in the subset
        int include = backtrack(
            nums,
            index + 1,
            currentXor ^ nums[index]
        );

        // Choice 2: Exclude nums[index] from the subset
        int exclude = backtrack(
            nums,
            index + 1,
            currentXor
        );

        // Sum XOR totals from both choices
        return include + exclude;
    }
}