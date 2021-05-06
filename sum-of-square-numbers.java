class Solution {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = findSqrt(c);
        System.out.println(high);
        int val = 0;
        while(low <= high) {
            val = low*low + high*high;
            if(val == c)
                return true;
            if(val < c)
                low++;
            else high--;
        }
        return false;
    }
    
    public int findSqrt(int n) {
        if(n == 0 || n == 1)
            return 1;
        int low = 0;
        int high = n;
        int mid = 0;
        long val = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            val = (long)mid * mid;
            if(val >= n) 
                high = mid;
            else low = mid + 1;
        }
        return low;
    }
}

// Time: log(n) + sqrt(n);

// M2
class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 2; i * i <= c; i++) {
            int count = 0;
            if(c % i == 0) {
                while(c % i == 0) {
                    count++;
                    c /= i;
                }
                if(i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
// sqrt(n)*log(n)