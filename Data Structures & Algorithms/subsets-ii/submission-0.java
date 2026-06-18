class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsequences(0, nums, current, res);
        return res;
    }

    public void subsequences(int index, int[] nums, List<Integer> current, List<List<Integer>> res){

        // Base case
        if(index == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(nums[index]);

        // pick
        subsequences(index + 1, nums, current, res);

        // remove last 
        current.remove(current.size() - 1);

        // no pick
        // Avoid all duplicates
        while((index + 1) < nums.length && nums[index] == nums[index + 1]){
            index++;
        }

        subsequences(index + 1, nums, current, res);
    }
}
