class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : arr) {
            if(isOpen(c))
                stack.push(c);
            else{
                c = findOpen(c);
                if(!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    
    public boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    public char findOpen(char c) {
        switch(c){
            case ')' : return '(';
            case '}' : return '{';
            case ']' : return '[';
            default: return '0';
        }
    }
}