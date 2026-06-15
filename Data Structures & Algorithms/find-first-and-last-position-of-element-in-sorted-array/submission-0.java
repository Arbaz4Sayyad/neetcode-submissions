class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        // int start = search(nums, target, true);
        // int end = search(nums, target, false);

        // ans[0] = start;
        // ans[1] = end;

        ans[0] = search(nums, target, true);
        if(ans[0] != -1){
            ans[1] = search(nums, target, false);
        }
    
        return ans;
    }
    public int search(int[] nums, int target, boolean findFirstIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2; // find middle element
            if(nums[mid] == target){
                ans = mid; // potential ans
                if(findFirstIndex){ 
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}