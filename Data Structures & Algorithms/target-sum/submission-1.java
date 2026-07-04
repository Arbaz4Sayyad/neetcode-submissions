class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        if (Math.abs(target) > totalSum)
            return 0;

        if ((totalSum + target) % 2 != 0)
            return 0;

        int sum = (totalSum + target) / 2;

        int n = nums.length;

        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int s = 0; s <= sum; s++) {

                int notTake = dp[i - 1][s];

                int take = 0;

                if (nums[i - 1] <= s)
                    take = dp[i - 1][s - nums[i - 1]];

                dp[i][s] = take + notTake;
            }
        }

        return dp[n][sum];
    }
}

// class Solution {

//     public int solve(int[] nums, int index, int target) {

//         if (index == nums.length) {
//             return target == 0 ? 1 : 0;
//         }

//         int plus = solve(nums, index + 1, target - nums[index]);

//         int minus = solve(nums, index + 1, target + nums[index]);

//         return plus + minus;
//     }

//     public int findTargetSumWays(int[] nums, int target) {
//         return solve(nums, 0, target);
//     }
// }
