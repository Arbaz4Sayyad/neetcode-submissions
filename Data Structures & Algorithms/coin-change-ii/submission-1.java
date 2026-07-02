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


class Solution {

    public int solve(int amount, int[] coins, int index, int[][] dp) {

        // Base Cases
        if (amount == 0)
            return 1;

        if (index < 0)
            return 0;

        // Check if already computed
        if (dp[index][amount] != -1)
            return dp[index][amount];

        // Don't take current coin
        int notTake = solve(amount, coins, index - 1, dp);

        // Take current coin
        int take = 0;
        if (coins[index] <= amount)
            take = solve(amount - coins[index], coins, index, dp);

        // Store and return
        return dp[index][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // Initialize with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(amount, coins, n - 1, dp);
    }
}