class Solution {
    public int countSquares(int[][] mat) {
        int ans = 0;
        for(int i = 0; i < mat.length; i++){
            for( int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1 && i > 0 && j > 0){
                    mat[i][j] = Math.min(mat[i-1][j-1], Math.min(mat[i-1][j], mat[i][j-1])) + 1;
                }
                ans += mat[i][j];
            }
        }
        return ans;
    }
}