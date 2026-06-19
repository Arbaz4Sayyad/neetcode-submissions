class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, current, res, nums, target);
        return res;
    }

    private void backtrack(int index, List<Integer> current, List<List<Integer>> res, int[] nums, int target) {
        // base case
        if(target == 0){
            res.add(new ArrayList<>(current));
            return;
        }

        if(index == nums.length){
            return;
        }

        // pick
        if(nums[index] <= target){
            current.add(nums[index]);
            backtrack(index, current, res, nums, target - nums[index]);
            current.remove(current.size() - 1);
        }

        // no-pick
        backtrack(index + 1, current, res, nums, target);
    }
}
