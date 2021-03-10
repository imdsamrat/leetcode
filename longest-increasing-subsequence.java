class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int lastIndex = 0;
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int idx = findCeilIndex(dp, 0, lastIndex, nums[i]);
            dp[idx] = nums[i];
            lastIndex = Math.max(lastIndex, idx);
        }
        return lastIndex + 1;
    }
    
    public int findCeilIndex(int[] dp, int low, int high, int val) {
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(val <= dp[mid]) 
                high = mid -1;
            else if (val > dp[mid])
                low = mid + 1;
        }
        if(low == high) {
            return val > dp[low] ? low + 1 : low;
        }
        return low;
    }
}