class Solution {
    static Map<Character, Integer> values = new HashMap<>();
    
    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }
    public int romanToInt(String s) {
        int size = s.length();
        int i = size -1;
        int ans = values.get(s.charAt(i));
        i--;
        while(i >= 0) {
            if(values.get(s.charAt(i)) < values.get(s.charAt(i+1)))
                ans -= values.get(s.charAt(i));
            else
                ans += values.get(s.charAt(i));
            i--;
        }
        return ans;
    }
}