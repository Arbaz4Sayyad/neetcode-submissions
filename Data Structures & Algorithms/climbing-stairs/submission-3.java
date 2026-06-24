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
    //     int[] ways = new int[n+1];
    //     Arrays.fill(ways, -1);

    //     return climbStairsMemo(n, ways);
    // }
    // public int climbStairsMemo(int n, int[] ways){
    //     if(n == 1 || n == 2){
    //         return n;
    //     }
    //     if(ways[n] != -1){
    //         return ways[n];
    //     }

    //     ways[n] = climbStairsMemo(n-1, ways) + climbStairsMemo(n-2, ways);
    //     return ways[n];
    // }

    // Approach 3 : Tabulation T: O(N) S: O(N)
    // public int climbStairs(int n){
    //     int[] ways = new int[n+1];
    
    //     return climbStairsTab(n, ways);
    // }
    // public int climbStairsTab(int n, int[] ways){
    //     ways[1] = 1;
    //     ways[2] = 2;

    //     for(int i=3; i<=n; i++){
    //         ways[i] = climbStairsTab(i-1, ways) + climbStairsTab(i-2, ways);
    //     }
    //     return ways[n];
    // }

    // Approach 4 : Space Optimization T: O(N) S: O(1)
    public int climbStairs(int n){

        if(n == 1 || n == 2){
            return n;
        }

        int prev1 = 2;
        int prev2 = 1;

        int ans = 0;

        for(int i=3; i<=n; i++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;

        } 
        return ans; // will point to current ans
    }
}