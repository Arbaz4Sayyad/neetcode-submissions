class Solution {
    public int[] sortedSquares(int[] nums) {

        // Result array to store squared values in sorted order
        int[] res = new int[nums.length];

        // Left pointer starting from beginning of array
        int i = 0;

        // Right pointer starting from end of array
        int j = nums.length - 1;

        // Position where we insert the largest square (start from end)
        int k = nums.length - 1;


        // Process elements from both ends until pointers meet
        while(i <= j){

            // Compare absolute values because negative numbers can
            // produce larger squares (example: -7^2 > 3^2)
            if(Math.abs(nums[i]) > Math.abs(nums[j])){

                // Left side has the bigger absolute value,
                // so its square will be the largest remaining value
                res[k] = nums[i] * nums[i];

                // Move left pointer forward
                i++;

            }else{

                // Right side has the bigger or equal absolute value,
                // place its square at current position
                res[k] = nums[j] * nums[j];

                // Move right pointer backward
                j--;
            }

            // Move result pointer backward because we fill
            // the array from largest square to smallest
            k--;
        }

        // Return sorted squared array
        return res;
    }
}