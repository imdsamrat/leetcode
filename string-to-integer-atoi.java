class Solution {
    int INT_MIN = Integer.MIN_VALUE;
    int INT_MAX = Integer.MAX_VALUE;
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if(str.length() == 0) return 0;
        
        //discard whitespaces in the beginning
        while(i < str.length() && str.charAt(i) == ' ')
            i++;
        
        //check if optional sign if it exists
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = str.charAt(i++)== '-' ? -1 : 1;
        
        //build the result and check for overflow or underflow condition
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if(result > INT_MAX / 10 || (result == INT_MAX / 10 && str.charAt(i) - '0' > INT_MAX % 10)) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;
    }
}