class Solution {
    public int R, C, ans;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        ans = 0;
        R = grid.length;
        C = grid[0].length;
        if(grid[0][0] != 0)
            return 0;
        dp = new int[R][C];
        dp[0][0] = 1;
        for(int i = 1; i < C; i++) {
            if(grid[0][i] == 0)
                dp[0][i] = dp[0][i-1];
        }
        for(int i = 1; i < R; i++) {
            if(grid[i][0] == 0)
                dp[i][0] = dp[i-1][0];
        }
        
        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                if(grid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[R-1][C-1];
    }
}