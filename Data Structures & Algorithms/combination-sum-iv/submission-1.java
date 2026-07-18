// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         int n = nums.length;
//         return findTotalCombiantions(n, nums, target);
//     }

//     private int findTotalCombiantions(int n, int[] nums, int target) {
//         if(target == 0) {
//             return 1;
//         }

//         if(target < 0) {
//             return 0;
//         } 

//         int result = 0;

//         for(int j = 0; j < n; j++) {
//             result += findTotalCombiantions(n, nums, target - nums[j]);
//         }

//         return result;
//     }
// }


// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         int n = nums.length;
//         int[] dp = new int[target+1];
//         Arrays.fill(dp, -1);

//         return findTotalCombiantions(n, nums, target, dp);
//     }

//     private int findTotalCombiantions(int n, int[] nums, int target, int[] dp) {
//         if(target == 0) {
//             return 1;
//         }

//         if(target < 0) {
//             return 0;
//         } 
//         if(dp[target] != -1) {
//             return dp[target];
//         }

//         int result = 0;

//         for(int j = 0; j < n; j++) {
//             result += findTotalCombiantions(n, nums, target - nums[j], dp);
//         }

//         dp[target] = result;

//         return dp[target];
//     }
// }

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);

        dp[0] = 1;

        for(int i = 1; i <= target; i++) {
            int result = 0;

            for(int j = 0; j < n; j++) {
                if(i - nums[j] >= 0) {
                    result += dp[i - nums[j]];
                }
            }
            dp[i] = result;
        }
        return dp[target];
    }
}