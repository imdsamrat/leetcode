class Solution {
    StringBuilder sb;
    public String decodeString(String s) {
        sb = new StringBuilder();
        decode(s, 0, s.length() -1);
        return sb.toString();
    }
    
    public void decode(String str, int low, int high) {
        if(high < low)
            return;
        if(!Character.isDigit(str.charAt(low))) {
            sb.append(str.charAt(low));
            decode(str, low + 1, high);
        } else {
            int num = 0;
            while(Character.isDigit(str.charAt(low))) {
                num = 10 * num + str.charAt(low++) -'0';
            }
            int start = low+1;
            Stack<Integer> s = new Stack<>();
            s.push(low++);
            while(!s.isEmpty() && low < str.length()) {
                if(str.charAt(low) == '[')
                    s.push(low);
                else if(str.charAt(low) == ']')
                    s.pop();
                low++;
            }
            int end = low - 2;
            for(int i = 0; i < num; i++) {
                decode(str, start, end);
            }
            decode(str, low, high);
        }
    }
    
}