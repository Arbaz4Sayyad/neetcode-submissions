// class Solution {

//     // Time: O(n)
//     // Space: O(n)
    
//     public int firstMissingPositive(int[] nums) {

//         HashSet<Integer> set = new HashSet<>();

//         for (int num : nums) {
//             if (num > 0)
//                 set.add(num);
//         }

//         int ans = 1;

//         while (set.contains(ans))
//             ans++;

//         return ans;
//     }
// }


class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Place every valid number at its correct position.
        // Value x should be placed at index x - 1.
        for (int i = 0; i < n; i++) {

            while (nums[i] >= 1 &&
                   nums[i] <= n &&
                   nums[i] != nums[nums[i] - 1]) {

                swap(nums, i, nums[i] - 1);
            }
        }

        // Find the first index where the value is incorrect.
        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1)
                return i + 1;
        }

        // If all positions are correct, answer is n + 1.
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}