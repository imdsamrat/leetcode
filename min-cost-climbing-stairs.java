class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0], b = cost[1];
        int t = 0;
        for(int i = 2; i < cost.length; i++){
            t = b;
            b = Math.min(a, b) + cost[i];
            a = t;
        }   
        return Math.min(a, b);
    }
}