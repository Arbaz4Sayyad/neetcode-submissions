class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, current, res, candidates, target);
        return res;
    }

    private void backtrack(int index, List<Integer> current, List<List<Integer>> res, int[] candidates, int target) {
        // base case
        if(target == 0){
            res.add(new ArrayList<>(current));
            return;
        }

        // if(index == candidates.length){
        //     return;
        // }

        for(int i = index; i < candidates.length; i++) {
            if((i == index || candidates[i] != candidates[i-1] ) && candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(i + 1, current, res, candidates, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        }
    }
}
