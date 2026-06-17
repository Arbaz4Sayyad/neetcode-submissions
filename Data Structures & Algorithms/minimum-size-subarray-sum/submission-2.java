class Solution {

    /*
     * Minimum Size Subarray Sum
     * -------------------------
     *
     * Given an array of positive integers and a target,
     * find the minimum length of a contiguous subarray
     * whose sum is greater than or equal to target.
     *
     * Return 0 if no such subarray exists.
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        // Stores minimum valid window length
        int minLength = Integer.MAX_VALUE;

        // Sliding window pointers
        int left = 0;
        int right = 0;

        // Current window sum
        int currSum = 0;

        while (right < n) {

            // Expand window by including nums[right]
            currSum += nums[right];

            /*
             * If current window satisfies the condition,
             * try shrinking it from the left to find
             * a smaller valid window.
             */
            while (currSum >= target) {

                minLength = Math.min(minLength, right - left + 1);

                // Remove leftmost element
                currSum -= nums[left];

                // Shrink window
                left++;
            }

            // Expand further
            right++;
        }

        /*
         * If no valid window found,
         * return 0.
         */
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
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