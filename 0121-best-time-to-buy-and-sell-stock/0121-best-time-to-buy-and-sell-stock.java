class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int profit=0;
            if(minPrice>prices[i]){
               minPrice=prices[i];
            }
            profit=prices[i]-minPrice;
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}