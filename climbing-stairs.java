class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2)
            return n;
        int a = 1, b = 2, t = 0;
        for(int i = 3; i <= n; i++){
            t = b;
            b = a + b;
            a = t;
        }
        return b;
    }
}