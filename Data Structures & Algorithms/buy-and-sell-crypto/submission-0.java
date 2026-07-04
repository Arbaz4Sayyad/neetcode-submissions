class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(buyPrice < price){
                int profit = price - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = price;
            }
        }
        return maxProfit;
    }
}