class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer ans = null;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(ans == null || (ans != null && Math.abs(sum - target) < Math.abs(ans - target)))
                    ans = sum;
                if(sum < target) {
                    lo++;
                } else if(sum > target) {
                    hi--;
                } else {
                    return target;                    
                }
            }
        }
        return ans;
    }
}