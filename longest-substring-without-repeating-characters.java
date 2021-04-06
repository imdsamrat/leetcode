class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < s.length()) {
            Integer idx = map.getOrDefault(s.charAt(r), null);
            if(idx != null && idx >= l)
                l = idx + 1;
            max = Math.max(max, r-l+1);
            map.put(s.charAt(r), r);
            r++;
        }
        return max;
    }
}