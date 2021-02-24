class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for(int i = 0; i < s.length();){
            while(j < t.length() && t.charAt(j) != s.charAt(i)){
                j++;   
            }
            if(j < t.length() && t.charAt(j) == s.charAt(i)){
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}