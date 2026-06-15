// class Solution {

    // public int singleNonDuplicate(int[] nums) {
    //     HashMap<Integer, Integer> freqMap = new HashMap<>();
    //     for(int num : nums){
    //         freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    //     }
    //     for(int num : nums){
    //         if(freqMap.get(num) == 1){
    //             return num;
    //         }
    //     }
    //     return -1;
    // }

    // public int singleNonDuplicate(int[] nums) {
    //     int unique = 0;
    //     for(int num : nums){
    //         unique ^= num;
    //     }
    //     return unique;
    // }
// }

class Solution {

    /*
     * Single Element in a Sorted Array
     * --------------------------------
     *
     * Given a sorted array where:
     * - Every element appears exactly twice
     * - One element appears only once
     *
     * Find the single element.
     *
     * TC: O(log N)
     * SC: O(1)
     *
     * Idea:
     * Before the single element:
     *     Pairs start at even indices.
     *
     * After the single element:
     *     Pairs start at odd indices.
     *
     * We use Binary Search to find the transition point.
     */
    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            /*
             * Make mid even.
             *
             * This helps us compare pairs:
             * nums[mid] and nums[mid + 1]
             */
            if (mid % 2 == 1) {
                mid--;
            }

            /*
             * Pair is valid.
             *
             * Example:
             * [1,1,2,2,3,3,4,5,5]
             *
             * mid = 2
             * nums[2] == nums[3]
             *
             * Single element must be on the right.
             */
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            }

            /*
             * Pair is broken.
             *
             * Single element is at mid
             * or somewhere on the left.
             */
            else {
                end = mid;
            }
        }

        return nums[start];
    }
}