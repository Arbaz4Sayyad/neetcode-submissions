class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] seen = new boolean[nums.length];
        backtrack(nums, seen, current, res);
        return res;
    }

    public void backtrack(int[] nums, boolean[] seen, List<Integer> current, List<List<Integer>> res){
        // base case
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // if seen then skip
            if(seen[i]){
                continue;
            }
            // Avoid duplicates
            if(i > 0 && nums[i] == nums[i-1] && !seen[i-1]){
                continue;
            }
            seen[i] = true;

            current.add(nums[i]);

            backtrack(nums, seen, current, res);

            current.remove(current.size() - 1);

            seen[i] = false;
        }
    }
}