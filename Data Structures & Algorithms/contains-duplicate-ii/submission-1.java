// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {

//             // If number already exists
//             if (map.containsKey(nums[i])) {

//                 int previousIndex = map.get(nums[i]);

//                 // Check distance between indices
//                 if (i - previousIndex <= k) {
//                     return true;
//                 }
//             }

//             // Store/update the latest index
//             map.put(nums[i], i);
//         }

//         return false;
//     }
// }

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k <= 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Duplicate found within distance k
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Remove element outside the window
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}