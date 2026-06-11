class Solution {

    /*
     * Helper function to find two numbers such that:
     *
     * nums[f] + nums[i] + nums[j] = 0
     *
     * Since the array is already sorted, we can use
     * the Two Pointer technique.
     */
    public void threeSumHelper(int f, int[] nums, List<List<Integer>> output) {

        // Left pointer starts after the fixed element
        int i = f + 1;

        // Right pointer starts at the end
        int j = nums.length - 1;

        while (i < j) {

            int sum = nums[f] + nums[i] + nums[j];

            if (sum > 0) {

                /*
                 * Sum is too large.
                 * Since array is sorted,
                 * move right pointer left to decrease sum.
                 */
                j--;

            } else if (sum < 0) {

                /*
                 * Sum is too small.
                 * Move left pointer right to increase sum.
                 */
                i++;

            } else {

                /*
                 * Found a valid triplet.
                 */
                output.add(Arrays.asList(nums[f], nums[i], nums[j]));

                // Move both pointers to find next unique triplet
                i++;
                j--;

                /*
                 * Skip duplicate values on the left side.
                 *
                 * Example:
                 * [-2, 0, 0, 0, 2]
                 *
                 * After using first 0, skip remaining 0s
                 * to avoid duplicate triplets.
                 */
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }

                /*
                 * Skip duplicate values on the right side.
                 */
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }

    /*
     * 3Sum
     * ----
     *
     * Find all unique triplets such that:
     *
     * nums[a] + nums[b] + nums[c] = 0
     *
     * TC: O(N²)
     * SC: O(1) Auxiliary Space
     *      (excluding output list)
     *
     * Approach:
     * 1. Sort the array.
     * 2. Fix one element.
     * 3. Use two pointers to find the remaining two elements.
     */
    public List<List<Integer>> threeSum(int[] nums) {

        // Sort array to apply two-pointer technique
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        // Fix one element at a time
        for (int f = 0; f < nums.length; f++) {

            /*
             * Since array is sorted,
             * if fixed element becomes positive,
             * all remaining elements will also be positive.
             *
             * Sum can never become 0.
             */
            if (nums[f] > 0) {
                break;
            }

            /*
             * Skip duplicate fixed elements.
             *
             * Example:
             * [-1, -1, -1, 0, 1]
             *
             * Process only the first -1.
             */
            if (f == 0 || nums[f] != nums[f - 1]) {
                threeSumHelper(f, nums, output);
            }
        }

        return output;
    }
}