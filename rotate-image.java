class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        rearrange(matrix, 0, N - 1);
    }
    
    public void rearrange(int[][] mat, int s, int N) {
        if(s == N)
            return;
        for(int i = s; i < N; i++) {
            int t = mat[s][i];
            mat[s][i] = mat[N-(i-s)][s];
            mat[N-(i-s)][s] = mat[N][N-(i-s)];
            mat[N][N-(i-s)] = mat[i][N];
            mat[i][N] = t;
        }
        if(s+1 <= N-1)
        rearrange(mat, s+1, N-1);
    }
}