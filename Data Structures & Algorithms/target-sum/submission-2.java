class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        // Calculate the total sum of all elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        /*
         * Let:
         * P = sum of elements assigned '+' sign
         * N = sum of elements assigned '-' sign
         *
         * We know:
         * P - N = target          ...(1)
         * P + N = totalSum        ...(2)
         *
         * Adding (1) and (2):
         *
         * 2 * P = totalSum + target
         *
         * Therefore,
         *
         * P = (totalSum + target) / 2
         *
         * So the problem becomes:
         *
         * Count the number of subsets having sum =
         * (totalSum + target) / 2
         */

        // If target is greater than total sum,
        // it is impossible to achieve.
        if (Math.abs(target) > totalSum) {
            return 0;
        }

        // If totalSum + target is odd,
        // required subset sum won't be an integer.
        if ((totalSum + target) % 2 != 0) {
            return 0;
        }

        int sum = (totalSum + target) / 2;

        int n = nums.length;

        /*
         * dp[i][j] =
         * Number of ways to form sum 'j'
         * using the first 'i' elements.
         */
        int[][] dp = new int[n + 1][sum + 1];

        /*
         * Base Case:
         *
         * Using 0 elements,
         * there is exactly one way to make sum 0
         * (choose nothing).
         */
        dp[0][0] = 1;

        // Build the DP table
        for (int i = 1; i <= n; i++) {

            for (int s = 0; s <= sum; s++) {

                // Option 1: Do not include current element
                int notTake = dp[i - 1][s];

                // Option 2: Include current element
                int take = 0;

                if (nums[i - 1] <= s) {
                    take = dp[i - 1][s - nums[i - 1]];
                }

                // Total number of ways
                dp[i][s] = take + notTake;
            }
        }

        // Number of subsets having required sum
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
