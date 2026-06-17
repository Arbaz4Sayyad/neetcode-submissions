class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int right=0;

        int currSum = 0;

        while(right < n){

            currSum += nums[right];

            while(currSum >= target){
                if(right-left+1 < minLength){
                    minLength = right - left + 1;
                }

                currSum -= nums[left];
                left++;
            }

            right++;
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }


    // TLE
    // public int minSubArrayLen(int target, int[] nums) {
    //     int size = Integer.MAX_VALUE;
    //     int sum = 0;

    //     for(int i=0; i<nums.length; i++){
    //         sum = 0;
    //         for(int j=i; j<nums.length; j++){
    //             sum += nums[j];

    //             if(sum >= target){
    //                 size = Math.min(size, j - i + 1);
    //                 break;
    //             }
    //         }
    //     }
    //     return size == Integer.MAX_VALUE ? 0 : size;
    // }
}