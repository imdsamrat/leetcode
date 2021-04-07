class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int min = s.length();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 0)
                min = Math.min(min, entry.getValue());
        }
        if(min != s.length())
            return min;
        return -1;
    }
}