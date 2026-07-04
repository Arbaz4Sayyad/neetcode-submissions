// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
        
//     }
// }

class Solution {

    public int solve(int[] nums, int index, int target) {

        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int plus = solve(nums, index + 1, target - nums[index]);

        int minus = solve(nums, index + 1, target + nums[index]);

        return plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target);
    }
}
