class Solution {
    public char nextGreatestLetter(char[] arr, char key) {
        int ans = binarySearch(arr, 0, arr.length-1, key);
        return arr[ans%arr.length];
    }
    
    public int binarySearch(char[] arr, int low, int high, char key) {
        if(low < high) {
            int mid = low+(high-low)/2;
            if(arr[mid] <= key)
                return binarySearch(arr, mid+1, high, key);
            return binarySearch(arr, low, mid, key);
        }
        if(low == high && arr[low] > key)
            return low;
        return low+1;
    }
}