class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int sum = 0;
        maxLeft[0] = arr[0];
        maxRight[n-1] = arr[n-1];
        int bestMax = arr[0];
        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(arr[i], maxLeft[i-1] + arr[i]);
            maxRight[n-1-i] = Math.max(arr[n-1-i], maxRight[n-1-i+1] + arr[n-1-i]);
            bestMax = Math.max(bestMax, maxLeft[i]);
        }
        int ans = bestMax;
        for(int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, maxLeft[i-1] + maxRight[i+1]);
        }
        return ans;
    }
}