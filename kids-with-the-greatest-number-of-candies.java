class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = findMax(candies);
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= maxCandy)
                ans.add(true);
            else 
                ans.add(false);
        }
        return ans;
    }
    
    public int findMax(int[] candies) {
        int maxCandy = 0;
        for(int i = 0; i < candies.length; i++){
            maxCandy = Math.max(maxCandy, candies[i]);
        }
        return maxCandy;
    }
}