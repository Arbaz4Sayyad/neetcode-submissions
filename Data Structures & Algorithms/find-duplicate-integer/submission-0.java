class Solution {
    public int findDuplicate(int[] nums) {
        // Approach 1 (Brute Force): Nested Loops TC: O(N^2) SC: O(1)
        // Approach 2 (Better): Set TC: O(N) SC: O(N)

        // Set<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     if(set.contains(num)){
        //         return num;
        //     }
        //     set.add(num);
        // }
        // return -1;

        // This is what asked in question
        // Approach 3 (Optimal) : TC: O(1) SC: O(1) 

        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast){
                break;
            }
        }while(slow != fast);

        int n1 = 0;
        int n2 = slow;

        while(n1 != n2){
            n1 = nums[n1];
            n2 = nums[n2];
        }

        return n1;
    }
}
