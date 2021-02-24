class Solution {
    public int countVowelStrings(int n) {
        if(n == 1)
            return 5;
        int[] way = {1, 1, 1, 1, 1};
        int sum = 5;
        for(int i = 2; i <= n; i++){
            sum = 1;
            for(int j = 1; j < 5; j++){
                way[j] = way[j] + way[j-1];
                sum += way[j];
            } 
        }
        return sum;
    }
}