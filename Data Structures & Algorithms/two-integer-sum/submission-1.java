class Solution {

    /*
     * Two Sum
     * --------
     *
     * Given an array of integers and a target value,
     * return the indices of the two numbers such that
     * they add up to the target.
     *
     * Optimal Approach: HashMap
     *
     * TC: O(N)
     * SC: O(N)
     *
     * Idea:
     * For every number nums[i], calculate:
     *
     * complement = target - nums[i]
     *
     * If the complement already exists in the HashMap,
     * then we have found the required pair.
     *
     * Otherwise, store the current number and its index
     * in the HashMap for future lookups.
     */
    public int[] twoSum(int[] nums, int target) {

        // Stores (number, index)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Number needed to reach the target
            int lookingFor = target - nums[i];

            /*
             * If complement already exists,
             * we have found:
             * nums[currentIndex] + nums[storedIndex] = target
             */
            if (map.containsKey(lookingFor)) {

                // Return indices of the pair
                return new int[] { map.get(lookingFor), i };

            } else {

                /*
                 * Store current number and its index
                 * so future elements can use it as a complement.
                 */
                map.put(nums[i], i);
            }
        }

        /*
         * According to the problem statement,
         * a valid answer always exists.
         *
         * This exception is added for safety.
         */
        throw new IllegalArgumentException("No valid pair found");
    }
}

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // Brute Force Approach
//         // for(int i=0; i<nums.length-1; i++){
//         //     for(int j=i+1; j<nums.length; j++){
//         //         if(nums[i] + nums[j] == target){
//         //             int[] a = {i, j};
//         //             return a;
//         //         }
//         //     }
//         // }
//         // return null;   
//     }
// }