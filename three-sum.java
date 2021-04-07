class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[lo], nums[hi])));
                    lo++;
                    hi--;
                    while(lo <= hi && nums[lo] == nums[lo - 1])
                        lo++;
                }
            }
        }
        return ans;
    }
}