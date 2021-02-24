class Solution {
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int maxElement = prices[prices.length-1];
        for(int i = prices.length -2; i >= 0; i--) {
            ans = Math.max(ans, maxElement - prices[i]);
            maxElement = Math.max(maxElement, prices[i]);
        }
        return Math.max(ans, 0);
    }
}
