class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[i][i] = 1;
        for(int it = 1; it < n; it++) {
            for(int i = 0; i < n - it; i++) {
                int j = it + i;
                if(chars[i] == chars[j])
                    dp[i][j] = i + 1 <= j - 1 ? 2 + dp[i + 1][j - 1] : 2;
                else 
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }
}

// https://www.youtube.com/watch?v=_nCsPn7_OgI