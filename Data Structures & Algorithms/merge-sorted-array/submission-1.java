class Solution {

    /*
     * Merge Sorted Array
     * ------------------
     * TC: O(m + n)
     * SC: O(1)
     *
     * nums1 has enough space to hold all elements from nums2.
     *
     * Idea:
     * Since nums1 already contains m sorted elements and nums2 contains
     * n sorted elements, we can merge them in-place.
     *
     * Instead of shifting elements in nums1, we start filling from the
     * end of nums1 because the extra space is available there.
     *
     * This avoids overwriting elements that we have not processed yet.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer to the last valid element in nums1
        int i = m - 1;

        // Pointer to the last element in nums2
        int j = n - 1;

        // Pointer to the last position of nums1
        // where merged elements will be placed
        int k = m + n - 1;

        /*
         * Compare elements from the end of both arrays.
         * Place the larger element at position k.
         */
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {

                // nums1 element is larger, place it at the end
                nums1[k] = nums1[i];
                i--;

            } else {

                // nums2 element is larger (or equal), place it at the end
                nums1[k] = nums2[j];
                j--;
            }

            // Move to the next position from the end
            k--;
        }

        /*
         * If nums2 still has remaining elements,
         * copy them into nums1.
         *
         * No need to copy remaining nums1 elements because
         * they are already in their correct positions.
         */
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}