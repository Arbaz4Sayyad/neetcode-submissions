class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        // if sum is total sum is even then only we can partition that sum in eqaul parts
        
        if(sum % 2 != 0) {
            return false;  // if odd then return false otherwise search for subset
        } 
            
        return isSubsetSum(nums, sum / 2); // if we find answer in one half then other half should be equal as it will be even total sum that's why we are sending sum/2 instead sum
    }
    
    public boolean isSubsetSum(int[] nums, int target) {

        int n = nums.length;

        // dp[i][j] = can we make sum j using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {

            for (int sum = 1; sum <= target; sum++) {

                // Option 1: Don't take current element
                boolean notTake = dp[i - 1][sum];

                // Option 2: Take current element (if possible)
                boolean take = false;

                if (nums[i - 1] <= sum) {
                    take = dp[i - 1][sum - nums[i - 1]];
                }

                dp[i][sum] = take || notTake;
            }
        }

        return dp[n][target];
    }
}


// class Solution {
//     public boolean canPartition(int[] nums) {
        
//         int sum = 0;
//         for(int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//         }
        
//         // if sum is total sum is even then only we can partition that sum in eqaul parts
        
//         if(sum % 2 != 0) {
//             return false;  // if odd then return false otherwise search for subset
//         } 
            
//         return isSubsetSum(nums, nums.length, sum / 2);
//     }

//     public boolean isSubsetSum(int[] nums, int n, int sum){
        
//         // Base Cases
//         if (sum == 0) {
//             return true;
//         }

//         if (n == 0) {
//             return false;
//         }
        
        
//         // choices
//         if (nums[n - 1] <= sum) {

//             // Include OR Exclude
//             return isSubsetSum(nums, n - 1, sum - nums[n - 1]) ||
//                   isSubsetSum(nums, n - 1, sum);
//         }

//         // Cannot include current element if the element is greater than sum itself
//         return isSubsetSum(nums, n - 1, sum);
        
//     }
// }