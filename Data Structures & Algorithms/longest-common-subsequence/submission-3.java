// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         return solve(n-1, m-1, text1, text2);
//     }

//     public int solve(int i, int j, String text1, String text2) {
//         if(i < 0 || j < 0) {
//             return 0;
//         }

//         if(text1.charAt(i) == text2.charAt(j)) {
//             return 1 + solve(i-1, j-1, text1, text2);
//         }else{
//             int case1 = solve(i-1, j, text1, text2);
//             int case2 = solve(i, j-1, text1, text2);

//             return Math.max(case1, case2);
//         }
//     }
// }


// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int[][] dp = new int[n+1][m+1];

//         for(int i=0; i<n+1; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return solve(n, m, text1, text2, dp);
//     }

//     public int solve(int i, int j, String text1, String text2, int[][] dp) {
//         if(i == 0 || j == 0) {
//             return 0;
//         }

//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         if(text1.charAt(i-1) == text2.charAt(j-1)) {
//             dp[i][j] = 1 + solve(i-1, j-1, text1, text2, dp);
//             return dp[i][j];
//         }else{
//             int case1 = solve(i-1, j, text1, text2, dp);
//             int case2 = solve(i, j-1, text1, text2, dp);

//             dp[i][j] = Math.max(case1, case2);
//             return dp[i][j];
//         }
//     }
// }

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int[][] dp = new int[n+1][m+1];
        
//         dp[0][0] = 0;

//         for(int i = 1; i < n+1; i++) {
//             for(int j = 1; j < m + 1; j++) {
//                 if(text1.charAt(i-1) == text2.charAt(j-1)) {
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 }else{
//                     int case1 = dp[i-1][j];
//                     int case2 = dp[i][j-1];

//                     dp[i][j] = Math.max(case1, case2);
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m+1];
        
        prev[0] = 0;

        for(int i = 1; i < n+1; i++) {
            int[] cur = new int[m+1];
            cur[0] = 0;

            for(int j = 1; j < m + 1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1];
                }else{
                    int case1 = prev[j];
                    int case2 = cur[j-1];

                    cur[j] = Math.max(case1, case2);
                }
            }

            prev = cur;
        }

        return prev[m];
    }
}