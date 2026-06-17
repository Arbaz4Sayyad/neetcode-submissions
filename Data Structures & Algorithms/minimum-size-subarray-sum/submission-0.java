class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;

        for(int right=0; right<n; right++){
            currSum += nums[right];
            while(currSum >= target){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                }
                currSum -= nums[left];
                left++;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}