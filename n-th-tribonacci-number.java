class Solution {
    public int tribonacci(int n) {
        if(n == 0 || n == 1)
            return n;
        if(n == 2)
            return 1;
        int a = 0, b = 1, c = 1, t1 = 0, t2 = 0;
        for(int i = 3; i <= n; i++){
            t1 = c;
            t2 = b;
            c = a + b + c;
            b = t1;
            a = t2;
        }
        return c;
    }
}