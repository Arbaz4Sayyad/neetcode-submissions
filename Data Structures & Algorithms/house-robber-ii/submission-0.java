class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // If there is only one house.
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude the last house.
        int case1 = robHelper(nums, 0, n - 2);

        // Case 2: Exclude the first house.
        int case2 = robHelper(nums, 1, n - 1);

        // Return the maximum profit.
        return Math.max(case1, case2);
    }

    // Space Optimized House Robber I
    public int robHelper(int[] nums, int start, int end) {

        // Only one house in this range.
        if (start == end) {
            return nums[start];
        }

        // dp[start]
        int prev2 = nums[start];

        // dp[start + 1]
        int prev1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {

            // Rob current house.
            int include = nums[i] + prev2;

            // Skip current house.
            int exclude = prev1;

            int curr = Math.max(include, exclude);

            // Move the window.
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}