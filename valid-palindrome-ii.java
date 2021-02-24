class Solution {
    public boolean validPalindrome(String str) {
        int s = 0;
        int e = str.length() - 1;
        while(s < e){
            if(str.charAt(s) != str.charAt(e)){
                return isPalindrome(str, s, e - 1) || isPalindrome(str, s + 1, e);
            }
            s++;
            e--;
        }
        return true;
    }
    
    public boolean isPalindrome(String str, int s, int e){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}