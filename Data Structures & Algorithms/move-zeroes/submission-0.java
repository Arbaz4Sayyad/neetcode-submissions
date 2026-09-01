class Solution {

    public void moveZeroes(int[] nums) {

        // 'nonZeroIndex' tells us where the next non-zero
        // element should be placed.
        int nonZeroIndex = 0;

        // Traverse the entire array
        for (int i = 0; i < nums.length; i++) {

            // If current element is non-zero
            if (nums[i] != 0) {

                // Swap current non-zero element with the element
                // at nonZeroIndex.
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;

                // Move the position for the next non-zero element
                nonZeroIndex++;
            }
        }
    }
}