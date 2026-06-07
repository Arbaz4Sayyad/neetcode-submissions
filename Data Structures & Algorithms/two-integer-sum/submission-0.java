class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Optimal Approach
        Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No solution more than one");

        // Brute Force Approach
        // for(int i=0; i<nums.length-1; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             int[] a = {i, j};
        //             return a;
        //         }
        //     }
        // }
        // return null;   
    }
}