class Solution {

    /*
     * Sort Colors
     * -----------
     *
     * Given an array containing only:
     * 0 -> Red
     * 1 -> White
     * 2 -> Blue
     *
     * Sort the array in-place without using any built-in sorting.
     *
     * Dutch National Flag Algorithm
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Idea:
     * Maintain three regions:
     *
     * 0 to i-1     -> all 0s
     * i to k-1     -> all 1s
     * k to j       -> unknown elements
     * j+1 to n-1   -> all 2s
     *
     * We process the unknown region one element at a time.
     */
    public void sortColors(int[] nums) {

        // Next position where 0 should be placed
        int i = 0;

        // Next position where 2 should be placed
        int j = nums.length - 1;

        // Current element being processed
        int k = 0;

        while (k <= j) {

            /*
             * Case 1:
             * Current element is 1.
             *
             * 1 belongs in the middle region,
             * so simply move ahead.
             */
            if (nums[k] == 1) {

                k++;

            }

            /*
             * Case 2:
             * Current element is 2.
             *
             * Move it to the right side.
             */
            else if (nums[k] == 2) {

                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;

                j--;

                /*
                 * IMPORTANT:
                 * Do NOT increment k here.
                 *
                 * Reason:
                 * The element swapped from the right side
                 * has not been processed yet.
                 *
                 * We must examine nums[k] again.
                 */
            }

            /*
             * Case 3:
             * Current element is 0.
             *
             * Move it to the left side.
             */
            else { // nums[k] == 0

                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

                i++;
                k++;

                /*
                 * We can move both pointers because:
                 *
                 * 1. nums[i] is now correctly placed.
                 * 2. The element swapped to k comes from
                 *    the middle region and is already processed.
                 */
            }
        }
    }
}