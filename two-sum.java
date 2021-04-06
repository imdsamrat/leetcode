class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int idx = map.getOrDefault(target - nums[i], -1);
            map.put(nums[i], i);
            if(idx >= 0)
                return new int[] {idx, i};
        }
        return new int[] {-1, -1};
    }
}