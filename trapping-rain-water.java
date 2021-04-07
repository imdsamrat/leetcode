class Solution {
    public int trap(int[] A) {
        int l = 0, r = A.length - 1;
        int ans = 0;
        
        while(l < r) {
            int lMax = A[l];
            int rMax = A[r];
            if(lMax <= rMax) {
                while(l < r && A[++l] <= lMax) {
                    ans += (lMax - A[l]);
                }
            } else {
                while(l < r && A[--r] <= rMax) {
                    ans += (rMax - A[r]);
                }
            }
        }
        return ans;
    }
}
