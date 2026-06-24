class Solution {
    // Approach 1 : Recursion T: O(2^N)
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     return recur(n, cost);
    // }

    // public int recur(int n, int[] cost) {
    //     if(n == 0 || n == 1){
    //         return 0;
    //     }

    //     int oneStep = cost[n-1] + recur(n-1, cost);
    //     int twoStep = cost[n-2] + recur(n-2, cost);
        
    //     return Math.min(oneStep, twoStep);
    // }

    // Approach 2 : Memoization T: O(N)

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return memo(n, cost, dp);
    }

    public int memo(int n, int[] cost, int[] dp) {
        if(n == 0 || n == 1){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int oneStep = cost[n-1] + memo(n-1, cost, dp);
        int twoStep = cost[n-2] + memo(n-2, cost, dp);
        
        dp[n] = Math.min(oneStep, twoStep);
        return dp[n];
    }
}
