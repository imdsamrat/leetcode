class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0, lans = 0;
        for(int i = 0;i<accounts.length;i++){
            lans = 0;
            for(int j = 0;j<accounts[0].length;j++){
                lans += accounts[i][j];
            }
            ans = Math.max(lans, ans);
        }
        return ans;
    }
}
