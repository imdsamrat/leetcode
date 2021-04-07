class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int ans = 0;
        for(int a : nums) {
            ans = ans ^ a ^ i;
            i++;
        }
        return ans ^ i;
    }
}