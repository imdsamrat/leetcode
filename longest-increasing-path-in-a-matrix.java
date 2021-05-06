class Solution {
    int[][] dp;
    int r, c;
    int ans;
    boolean[][] visited;
    boolean[][] visiting;
    int N = 4;
    int[] xMove = new int[] {0, 1, 0, -1};
    int[] yMove = new int[] {1, 0, -1, 0};
    int[][] grid;
    public int longestIncreasingPath(int[][] matrix) {
        grid = matrix;
        r = matrix.length;
        c = matrix[0].length;
        dp = new int[r][c];
        visited = new boolean[r][c];
        visiting = new boolean[r][c];
        for(int[] a : dp) {
            Arrays.fill(a, 1);
        }
        ans = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!visited[i][j])
                    dfs(i, j);
            }
        }

        return ans;
    }
    
    public int dfs(int x, int y) {
        if(visiting[x][y])
            return 0;
        if(visited[x][y])
            return dp[x][y];
        visiting[x][y] = true;
        visited[x][y] = true;
        for(int i = 0; i < N; i++){
            int nx = x + xMove[i];
            int ny = y + yMove[i];
            if(isSafe(nx, ny) && grid[x][y] < grid[nx][ny])
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+ 1);
        }
        visiting[x][y] = false;
        ans = Math.max(ans, dp[x][y]);
        return dp[x][y];
    }
    
    public boolean isSafe(int x, int y) {
        return x >= 0 && x < r
            && y >= 0 && y < c;
    }
    
}