class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        for(int[] a : dp)
            Arrays.fill(a, -1);
        return LCS(s1, s2, m - 1, n - 1);
    }
    
    public int LCS(String x, String y, int m, int n) {
        if(m < 0 || n < 0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(x.charAt(m) == y.charAt(n))
            dp[m][n] = LCS(x, y, m - 1, n - 1) + 1;
        else 
            dp[m][n] = Math.max(LCS(x, y, m - 1, n), LCS(x, y, m, n - 1));
        return dp[m][n];
    }
}