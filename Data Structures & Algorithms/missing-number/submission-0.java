class Solution {
    // public int missingNumber(int[] nums) {
    //     int n = nums.length;
    //     for(int i=0; i<=n; i++){
    //         boolean found = false;
    //         for(int num : nums){
    //             if(num == i){
    //                 found = true;
    //                 break;
    //             }
    //         }
    //         if(!found){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }


    // public int missingNumber(int[] nums) {
    //     int n = nums.length;
    //     int expectedSum = n*(n+1)/2;
    //     int actualSum = 0;

    //     for(int i=0; i<n; i++){
    //         actualSum += nums[i];
    //     }
    //     return expectedSum - actualSum;
    // }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = 0;

        // XOR of all element from 0 to n
        for(int i=0; i<=n; i++){
            missing ^= i;
        }

        // XOR of all array element
        for(int num : nums){
            missing ^= num;
        }

        return missing; // missing number
    }
}