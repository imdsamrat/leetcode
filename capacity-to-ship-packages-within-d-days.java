class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int max = 0, sum = 0;
        for(int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        
        int low = max, high = sum;
        int retVal = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int d = findNoOfDays(weights, mid);
            if(d > D) {
                low = mid + 1;
            } else {
                retVal = mid;
                high = mid - 1;
            }
        }
        return retVal;
    }
    
    public int findNoOfDays(int[] weights, int capacity) {
        int sum = 0, days = 1;
        for(int i = 0; i < weights.length; i++) { 
            sum += weights[i];
            if(sum > capacity) {
                days++;
                sum = weights[i];
            }
        }
        return days;
    }
}
//  Time: O(n)*O(log(max-min))