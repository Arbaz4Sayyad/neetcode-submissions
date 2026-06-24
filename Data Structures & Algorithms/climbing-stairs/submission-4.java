class Solution {
    // Approach 1 : Recursion T: O(N) S: O(N)
    // public int climbStairs(int n) {
    //     if(n == 1 || n == 2){
    //         return n;
    //     }

    //     return climbStairs(n-1) + climbStairs(n-2);
    // }

    // Approach 2 : Memoization T: O(N) S: O(N)
    // public int climbStairs(int n){
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);

    //     return climbStairsMemo(n, dp);
    // }
    // public int climbStairsMemo(int n, int[] dp){
    //     if(n == 1 || n == 2){
    //         return n;
    //     }
    //     if(dp[n] != -1){
    //         return dp[n];
    //     }

    //     dp[n] = climbStairsMemo(n-1, dp) + climbStairsMemo(n-2, dp);
    //     return dp[n];
    // }

    // Approach 3 : Tabulation T: O(N) S: O(N)
    public int climbStairs(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int state=3; state<=n; state++){
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }

    // Approach 4 : Space Optimization T: O(N) S: O(1)
    // public int climbStairs(int n){

    //     if(n == 1 || n == 2){
    //         return n;
    //     }

    //     int prev1 = 2;
    //     int prev2 = 1;

    //     int ans = 0;

    //     for(int i=3; i<=n; i++){
    //         ans = prev1 + prev2;
    //         prev2 = prev1;
    //         prev1 = ans;

    //     } 
    //     return ans; // will point to current ans
    // }
}