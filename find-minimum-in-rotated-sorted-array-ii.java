class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            if(arr[mid] < arr[high])
                high = mid;
            else if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high--;
        }
        return arr[low];
    }
}