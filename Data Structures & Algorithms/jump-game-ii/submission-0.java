class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int maxReach = 0;
        int currentLoc = 0;

        for(int i=0; i<nums.length-1; i++){
            maxReach = Math.max(maxReach, i+nums[i]); // 2

            // If we've reached the end of the current jump range
            if(i == currentLoc){
                jumps++;
                currentLoc = maxReach;
            }

            // Early exit if we already reached or passed the last index
            if(currentLoc >= nums.length-1){
                break; // 2
            }
        }
        return jumps;
    }
}