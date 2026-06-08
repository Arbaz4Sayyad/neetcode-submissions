class Solution {
    // Approach 1 : Recursion T: O(N) S: O(N)
    // public int climbStairs(int n) {
    //     if(n == 0 || n == 1){
    //         return 1;
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
    //     if(n == 0 || n == 1){
    //         return 1;
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
    //     ways[0] = 1;
    //     ways[1] = 1;

    //     for(int i=2; i<=n; i++){
    //         ways[i] = climbStairsTab(i-1, ways) + climbStairsTab(i-2, ways);
    //     }
    //     return ways[n];
    // }

    // Approach 4 : Space Optimization T: O(N) S: O(1)
    public int climbStairs(int n){

        if(n == 0 || n == 1){
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;

        for(int i=2; i<=n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;

        } 
        return prev1; // will point to current ans
    }
}
// class Solution {
//     public int climbStairs(int n) {
//         return climbStairsRec(0, n);
//     }

//     int climbStairsRec(int i, int n){
//         if(i == n){
//             return 1;
//         }
//         if(i > n){
//             return 0;
//         }

//         return climbStairsRec(i+1, n) + climbStairsRec(i+2, n);
//     }
// }
