class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int max = 1;
        for(int i = 0; i < s.length(); i++) {
            int len = findPalin(chars, i, i) - 1;
            int len2 = (i+1 < chars.length) ? findPalin(chars, i, i + 1) : 0;
            if(Math.max(len, len2) > max) {
                max = Math.max(len, len2);
                ans = i;
            }
        }
        return s.substring(ans-(max-1)/2, ans+(max/2+1));
    }
    
    public int findPalin(char[] chars, int l, int r) {
        if(l<0||r>=chars.length)
            return 0;
        if(chars[l] == chars[r])
            return 2 + findPalin(chars, l - 1, r + 1);
        return 0;
    }
    
}