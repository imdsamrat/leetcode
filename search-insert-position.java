class Solution {
    public int searchInsert(int[] arr, int key) {
        return binarySearch(arr, 0, arr.length-1, key);
    }
    
    public int binarySearch(int[] arr, int low, int high, int key) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == key)
                return mid;
            if(key < arr[mid])
                return binarySearch(arr, low, mid, key);
            return binarySearch(arr, mid + 1, high, key);
        }
        if(low == high && arr[low] < key)
            return low + 1;
        return low;
    }
}