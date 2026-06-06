class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2; // To find middle index

            if(target == nums[mid]){
                return mid;
            }

            // if left side is sorted
            if(nums[start] <= nums[mid]){
                // ans  can be found in left side
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            } else{ // if right side is sorted
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}