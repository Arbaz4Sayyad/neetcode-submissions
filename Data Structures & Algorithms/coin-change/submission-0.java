class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int res = recur(coins, amount, n - 1);
        if(res == (int)(1e9)) {
            return -1;
        }
        return res;
    }

    public int recur(int[] coins, int amount, int index) {
        if(index == 0) {
            if(amount % coins[index] == 0) {
                return amount / coins[index];
            }
            return (int)(1e9);
        }

        int include = (int)(1e9);

        if(amount >= coins[index]) {
            include = 1 + recur(coins, amount - coins[index], index);
        }

        int exclude = 0 + recur(coins, amount, index - 1);

        return Math.min(include, exclude);
    }
}
