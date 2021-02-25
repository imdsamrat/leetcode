class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] answer = new int[r][c];
       
        for(int i = 1; i < c; i++){
            mat[0][i] = mat[0][i] + mat[0][i-1];
        }
        for(int i = 1; i < r; i++){
            mat[i][0] = mat[i][0] + mat[i-1][0];
        }
        
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                mat[i][j] = mat[i][j] + mat[i-1][j] + mat[i][j-1] -mat[i-1][j-1];
            }
        }
        // System.out.println(Arrays.deepToString(mat));
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                
                int A = findA(mat, r, c, i, j, k);
                int B = findB(mat, r, c, i, j, k);
                int C = findC(mat, r, c, i, j, k);
                int D = findD(mat, r, c, i, j, k);
                // System.out.println(A + " " + B + " " + C + " " + D);
                answer[i][j] = A - (B + C);
                if(B != 0 && C != 0){
                    answer[i][j] += D;
                }
            }
        }
        
        return answer;
    }
    
    public int findA(int[][] mat, int r, int c, int i, int j, int k) {
        if(i+k < r && j+k<c)
            return mat[i+k][j+k];
        if(i+k < r)
            return mat[i+k][c-1];
        if(j+k < c)
            return mat[r-1][j+k];
        return mat[r-1][c-1];
    }
    
    public int findB(int[][] mat, int r, int c, int i, int j, int k) {
        if(i-(k+1) >= 0  && j+k < c)
            return mat[i-(k+1)][j+k];
        if(i-(k+1) >= 0 )
            return mat[i-(k+1)][c-1];
        return 0;
    }
    
    public int findC(int[][] mat, int r, int c, int i, int j, int k) {
        if(i+k < r  && j-(k+1) >= 0)
            return mat[i+k][j-(k+1)];
        if(j-(k+1) >= 0)
            return mat[r-1][j-(k+1)];
        return 0;
    }
    
    public int findD(int[][] mat, int r, int c, int i, int j, int k) {
        k += 1;
        if(i-k >= 0 && j-k >= 0)
            return mat[i-k][j-k];
        return 0;
    }
    
}