// class Solution {

//     public int solve(int amount, int[] coins, int index) {

//         if (amount == 0)
//             return 1;

//         if (index < 0)
//             return 0;

//         int notTake = solve(amount, coins, index - 1);

//         int take = 0;
//         if (coins[index] <= amount)
//             take = solve(amount - coins[index], coins, index);

//         return take + notTake;
//     }

//     public int change(int amount, int[] coins) {
//         return solve(amount, coins, coins.length - 1);
//     }
// }


// class Solution {

//     public int solve(int amount, int[] coins, int index, int[][] dp) {

//         // Base Cases
//         if (amount == 0)
//             return 1;

//         if (index < 0)
//             return 0;

//         // Check if already computed
//         if (dp[index][amount] != -1)
//             return dp[index][amount];

//         // Don't take current coin
//         int notTake = solve(amount, coins, index - 1, dp);

//         // Take current coin
//         int take = 0;
//         if (coins[index] <= amount)
//             take = solve(amount - coins[index], coins, index, dp);

//         // Store and return
//         return dp[index][amount] = take + notTake;
//     }

//     public int change(int amount, int[] coins) {

//         int n = coins.length;

//         int[][] dp = new int[n][amount + 1];

//         // Initialize with -1
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return solve(amount, coins, n - 1, dp);
//     }
// }


class Solution {

    public int change(int amount, int[] coins) {

        int n = coins.length;

        /*
         * dp[i][j]
         * = Number of ways to make amount 'j'
         *   using coins from index 0 to i.
         */
        int[][] dp = new int[n][amount + 1];

        /*
         * Base Case:
         *
         * If only the first coin is available,
         * then amount 'j' can be formed
         * only if j is divisible by coins[0].
         *
         * There is exactly ONE way.
         */
        for (int j = 0; j <= amount; j++) {

            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            }
        }

        // Process remaining coin types
        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= amount; j++) {

                // Option 1: Do not use current coin
                int notTake = dp[i - 1][j];

                // Option 2: Use current coin
                int take = 0;

                if (coins[i] <= j) {

                    /*
                     * Stay on the same row because
                     * the current coin can be used
                     * unlimited times.
                     */
                    take = dp[i][j - coins[i]];
                }

                // Total ways = take + notTake
                dp[i][j] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }
}