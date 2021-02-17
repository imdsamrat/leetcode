class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int curr = 0;
        int p = 0;
        for(int i = 0;i<arr.length;i++){
            p = (arr[i] - curr - 1);
            if(k<=missing + p){
                return curr + (k-missing);
            }else {
                missing += p;
            }
            curr = arr[i];
        }
        return curr + (k-missing);
    }
}
