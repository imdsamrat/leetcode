class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lmax = -1, rmax = -1;
        for(int i = 0; i< n; i++) {
            leftMax[i] = lmax;
            lmax = Math.max(lmax, height[i]);
            rightMax[n - 1 -i] = rmax;
            rmax = Math.max(rmax, height[n - 1 - i]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return ans;
    }
}

class Solution {
    public int trap(int[] A) {
        int ans = 0;
        int l = 0, r = A.length - 1;
        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volume until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volume until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
}