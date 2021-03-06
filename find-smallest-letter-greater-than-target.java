class Solution {
    public char nextGreatestLetter(char[] arr, char ch) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            if(arr[mid] <= ch) 
                low = mid + 1;
            else high = mid;
        }
        if(arr[low] <= ch) return arr[(low + 1) % arr.length];
        return arr[low];
    }
}