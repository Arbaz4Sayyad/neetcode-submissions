// class Solution {

//     public int lastStoneWeightII(int[] stones) {

//         int totalSum = 0;
//         for (int stone : stones) {
//             totalSum += stone;
//         }

//         int target = totalSum / 2;

//         // Maximum subset sum <= target
//         int subsetSum = solve(0, target, stones);

//         return totalSum - 2 * subsetSum;
//     }

//     // Returns maximum achievable subset sum
//     private int solve(int index, int remaining, int[] stones) {

//         // No stones left
//         if (index == stones.length) {
//             return 0;
//         }

//         // Option 1: Skip current stone
//         int notTake = solve(index + 1, remaining, stones);

//         // Option 2: Take current stone (if possible)
//         int take = 0;

//         if (stones[index] <= remaining) {
//             take = stones[index] +
//                     solve(index + 1,
//                           remaining - stones[index],
//                           stones);
//         }

//         return Math.max(take, notTake);
//     }
// }

class Solution {

    int[][] dp;

    public int lastStoneWeightII(int[] stones) {

        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;

        dp = new int[stones.length][target + 1];

        // -1 means not computed
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int subsetSum = solve(0, target, stones);

        return totalSum - 2 * subsetSum;
    }

    private int solve(int index, int remaining, int[] stones) {

        // No stones left
        if (index == stones.length) {
            return 0;
        }

        // Already computed
        if (dp[index][remaining] != -1) {
            return dp[index][remaining];
        }

        // Skip current stone
        int notTake = solve(index + 1, remaining, stones);

        // Take current stone
        int take = 0;

        if (stones[index] <= remaining) {
            take = stones[index]
                    + solve(index + 1,
                            remaining - stones[index],
                            stones);
        }

        return dp[index][remaining] = Math.max(take, notTake);
    }
}