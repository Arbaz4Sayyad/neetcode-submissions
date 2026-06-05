class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int ans = 0;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(mid + 1 < n && nums[mid] < nums[mid+1]){ // i am in ascending part
                left = mid+1;
            }else { // i am in descending part
                ans = mid;
                right = mid-1;
            }
        }
        return ans;
    }
}