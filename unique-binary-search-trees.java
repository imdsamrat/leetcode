class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        return numTreesUtil(n);
    }
    
    public int numTreesUtil(int n) {
        if(n == 0 || n == 1)
            return 1;
        if(dp[n] > 0)
            return dp[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (numTreesUtil(i) * numTreesUtil(n-i-1)); 
        }
        dp[n] = sum;
        return dp[n];
    }
}