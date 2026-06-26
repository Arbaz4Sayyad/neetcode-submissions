class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // public static int majorityElement(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int n = nums.length;

    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);

    //         if (map.get(num) > n / 2) {
    //             return num;
    //         }
    //     }

    //     return -1; // No majority element
    // }
}