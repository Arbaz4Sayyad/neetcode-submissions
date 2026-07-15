// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int n = nums.length;
//         int maxLen = 0;

//         // Try every index as the starting point
//         for (int i = 0; i < n; i++) {

//             // Skip if the starting element is 0
//             if (nums[i] == 0) {
//                 continue;
//             }

//             int len = 0;

//             // Count consecutive 1s starting from i
//             for (int j = i; j < n; j++) {
//                 if (nums[j] == 1) {
//                     len++;
//                 } else {
//                     break;
//                 }
//             }

//             maxLen = Math.max(maxLen, len);
//         }

//         return maxLen;
//     }
// }

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int currentLen = 0;

        for (int j = 0; j < n; j++) {
            if(nums[j] == 1) {
                currentLen++;
                maxLen = Math.max(currentLen, maxLen);
            }else{
                currentLen = 0;
            }
        }

        return maxLen;
    }
}