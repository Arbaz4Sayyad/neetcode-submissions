// class Solution {
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     return helper(nums, n - 1);
    // }

    // public int helper(int[] nums, int index) {
    //     // Base Case
    //     if(index == 0) {
    //         return nums[0];
    //     }
    //     if(index < 0) {
    //         return 0;
    //     }

    //     int include = nums[index] + helper(nums, index-2);
    //     int exclude = 0 + helper(nums, index-1);

    //     return Math.max(include, exclude);
    // }


    // public int rob(int[] nums) {
    //     int n = nums.length;

    //     // dp[index] stores the maximum money that can be robbed up to the given index.
    //     // We use size 'n' (not n + 1) because the valid indices are only 0 to n - 1.
    //     // We never store the result for index < 0; we directly return 0 in the base case.
    //     int[] dp = new int[n];

    //     // Initialize all values with -1 (means not computed yet)
    //     Arrays.fill(dp, -1);

    //     return helper(nums, n - 1, dp);
    // }

    // public int helper(int[] nums, int index, int[] dp) {
    //     // Base Case 1:
    //     // If we are at the first house, rob it.
    //     if (index == 0) {
    //         return nums[0];
    //     }

    //     // Base Case 2:
    //     // If index becomes negative, no house is left.
    //     if (index < 0) {
    //         return 0;
    //     }

    //     // If answer is already calculated, return it.
    //     if (dp[index] != -1) {
    //         return dp[index];
    //     }

    //     // Option 1: Rob the current house
    //     // Then we cannot rob the previous house.
    //     int include = nums[index] + helper(nums, index - 2, dp);

    //     // Option 2: Skip the current house
    //     int exclude = helper(nums, index - 1, dp);

    //     // Store the maximum profit for this index
    //     dp[index] = Math.max(include, exclude);

    //     return dp[index];
    // }

//     public int rob(int[] nums) {
//         int n = nums.length;

//         // If there is only one house, rob it.
//         if (n == 1) {
//             return nums[0];
//         }

//         // dp[i] stores the maximum money that can be robbed
//         // from houses 0 to i.
//         int[] dp = new int[n];

//         // Base Case:
//         // If there is only one house, rob it.
//         dp[0] = nums[0];

//         // For the first two houses, rob the one with more money.
//         dp[1] = Math.max(nums[0], nums[1]);

//         // Fill the DP array from left to right.
//         for (int i = 2; i < n; i++) {

//             // Option 1: Rob the current house.
//             // Then we cannot rob the previous house.
//             int include = nums[i] + dp[i - 2];

//             // Option 2: Skip the current house.
//             int exclude = dp[i - 1];

//             // Store the maximum profit.
//             dp[i] = Math.max(include, exclude);
//         }

//         // The last element contains the maximum money that can be robbed.
//         return dp[n - 1];
//     }
// }


class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        // If there is only one house, rob it.
        if (n == 1) {
            return nums[0];
        }

        // prev2 = dp[i-2]
        int prev2 = nums[0];

        // prev1 = dp[i-1]
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            // Rob current house
            int include = nums[i] + prev2;

            // Skip current house
            int exclude = prev1;

            // Current maximum profit
            int curr = Math.max(include, exclude);

            // Move the window forward
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}