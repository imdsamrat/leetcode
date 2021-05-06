class Solution {
    int N = 4;
    int[] xMove = new int[] {0, 1, 0, -1};
    int[] yMove = new int[] {1, 0, -1, 0};
    int r, c;
    char[][] grid;
    public int numIslands(char[][] grida) {
        grid = grida;
        r = grid.length;
        c = grid[0].length;
        int ans = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void dfs(int x, int y) {
        grid[x][y] = 0;
        for(int i = 0; i < N; i++) {
            int nX = x + xMove[i];
            int nY = y + yMove[i];
            if(isSafe(nX, nY))
                dfs(nX, nY);
        }
    }
    
    public boolean isSafe(int x, int y) {
        return x >= 0 && x < r
            && y >= 0 && y < c
            && grid[x][y] == '1';
    }
}