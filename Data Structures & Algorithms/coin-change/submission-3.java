// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;

//         int res = recur(coins, amount, n - 1);
//         if(res == (int)(1e9)) {
//             return -1;
//         }
//         return res;

//         return res >= (int)(1e9) ? -1 : res;
//     }

//     public int recur(int[] coins, int amount, int index) {
//         if(index == 0) {
//             if(amount % coins[index] == 0) {
//                 return amount / coins[index];
//             }
//             return (int)(1e9);
//         }

//         int include = (int)(1e9);

//         if(amount >= coins[index]) {
//             include = 1 + recur(coins, amount - coins[index], index);
//         }

//         int exclude = 0 + recur(coins, amount, index - 1);

//         return Math.min(include, exclude);
//     }
// }


// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         int res = recur(coins, amount, n - 1, dp);

//         if(res == (int)(1e9)) {
//             return -1;
//         }
//         return res;
//     }

//     public int recur(int[] coins, int amount, int index, int[][] dp) {
//         if(index == 0) {
//             if(amount % coins[index] == 0) {
//                 dp[index][amount] = amount / coins[index];
//                 return amount / coins[index];
//             }
//             return (int)(1e9);
//         }

//         int include = (int)(1e9);

//         if(amount >= coins[index]) {
//             include = 1 + recur(coins, amount - coins[index], index, dp);
//         }

//         if(dp[index][amount] != -1) {
//             return dp[index][amount];
//         }

//         int exclude = 0 + recur(coins, amount, index - 1, dp);

//         dp[index][amount] = Math.min(include, exclude);

//         return dp[index][amount];
//     }
// }


// class Solution {

//     public int coinChange(int[] coins, int amount) {

//         int n = coins.length;

//         /*
//          * dp[i][j]
//          * = Minimum number of coins required
//          *   to make amount 'j'
//          *   using coins from index 0 to i.
//          */
//         int[][] dp = new int[n][amount + 1];

//         /*
//          * Base Case:
//          *
//          * If only the first coin is available,
//          * then we can form amount 'j' only if
//          * j is divisible by coins[0].
//          *
//          * Otherwise, it is impossible.
//          */
//         for (int j = 0; j <= amount; j++) {

//             if (j % coins[0] == 0) {
//                 dp[0][j] = j / coins[0];
//             } else {
//                 dp[0][j] = (int) 1e9; // Infinity (Impossible)
//             }
//         }

//         // Process remaining coin types
//         for (int i = 1; i < n; i++) {

//             for (int j = 0; j <= amount; j++) {

//                 // Option 1: Do not use current coin
//                 int notTake = dp[i - 1][j];

//                 // Option 2: Use current coin
//                 int take = (int) 1e9;

//                 if (coins[i] <= j) {

//                     /*
//                      * Stay on the same row because
//                      * the same coin can be used
//                      * multiple times (Unbounded Knapsack).
//                      */
//                     take = 1 + dp[i][j - coins[i]];
//                 }

//                 // Choose minimum coins
//                 dp[i][j] = Math.min(take, notTake);
//             }
//         }

//         // If still infinity, amount cannot be formed
//         if (dp[n - 1][amount] >= (int) 1e9) {
//             return -1;
//         }

//         return dp[n - 1][amount];
//     }
// }

class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, (int) 1e9);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
        }

        // If still infinity, amount cannot be formed
        if (dp[amount] >= (int) 1e9) {
            return -1;
        }

        return dp[amount];
    }
}