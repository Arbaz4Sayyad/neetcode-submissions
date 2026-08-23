// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n = nums.length;
//         int count = 0;
        
//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums[i];
//                 if(sum == k){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int subarraySum(int[] nums, int k) {

        // Stores:
        // prefixSum -> frequency
        Map<Integer, Integer> map = new HashMap<>();

        // Important:
        // Prefix sum 0 has appeared once before
        // the array starts.
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            // Calculate prefix sum
            currentSum += num;

            // We need a previous prefix sum such that:
            //
            // currentSum - previousSum = k
            //
            // Therefore:
            // previousSum = currentSum - k
            int requiredSum = currentSum - k;

            // If this prefix sum existed before,
            // every occurrence gives us one valid subarray.
            if (map.containsKey(requiredSum)) {
                count += map.get(requiredSum);
            }

            // Store/update the frequency of current prefix sum
            map.put(
                currentSum,
                map.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }
}