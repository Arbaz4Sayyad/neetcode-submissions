// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int n = nums.length;
//         int maxLen = 0;

//         for(int i = 0; i < n; i++) {
//             int zeroCount = 0;

//             for(int j = i; j < n; j++) {
//                 if(nums[j] == 0) {
//                     zeroCount++;
//                 }

//                 if(zeroCount > k) {
//                     break;
//                 }

//                 maxLen = Math.max(maxLen, j - i + 1);
//             }
//         }

//         return maxLen;
//     }
// }


class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int zeroCount = 0;
        int left = 0;

        for(int right = 0; right < n; right++) {

            if(nums[right] == 0) {
                zeroCount++;
            }

            while(zeroCount > k) {
                if(nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}