class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            // Case 1: Duplicates on both ends
            // We cannot determine which side is sorted.
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }

            // Case 2: Left half is sorted
            else if (nums[left] <= nums[mid]) {

                // Target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } 
                // Target lies in the right half
                else {
                    left = mid + 1;
                }
            }

            // Case 3: Right half is sorted
            else {

                // Target lies in the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } 
                // Target lies in the left half
                else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}