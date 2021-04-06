class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int n : nums) {
            if(map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            i++;
        }
        return new int[]{-1, -1};
    }
}