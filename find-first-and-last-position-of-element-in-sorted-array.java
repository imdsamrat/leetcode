class Solution {
    int l = -1, r = -1;
    public int[] searchRange(int[] arr, int target) {
        if(arr.length == 0)
            return new int[]{l, r};
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low + 1 < high) {
            mid = low + (high - low) / 2;
            if(target < arr[mid])
                high = mid - 1; 
            else if (target > arr[mid])
                low = mid + 1;
            else high = mid;
        }
        if(arr[low] == target) l = low;
        else if(arr[high] == target) l = high;
        
        low = 0;
        high = arr.length - 1;
        while(low + 1 < high) {
            mid = low + (high - low) / 2;
            if(target < arr[mid])
                high = mid - 1; 
            else if (target > arr[mid])
                low = mid + 1;
            else low = mid;
        }
        if(arr[high] == target) r = high;
        else if(arr[low] == target) r = low;
        
        
        return new int[]{l, r};
        
    }
}


//M2

class Solution {
    int l = -1, r = -1;
    public int[] searchRange(int[] arr, int target) {
        if(arr.length == 0)
            return new int[]{l, r};
        l = findBound(arr, target, true);
        r = findBound(arr, target, false);
        
        return new int[]{l, r};
        
    }
    
    public int findBound(int[] arr, int target, boolean isFirst) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(target < arr[mid])
                high = mid - 1; 
            else if (target > arr[mid])
                low = mid + 1;
            // found a target
            else if(isFirst) { 
                if(mid == low || arr[mid - 1] != target) 
                    return mid;
                else 
                    high = mid - 1;
            } else {
                if(mid == high || arr[mid + 1] != target) 
                    return mid;
                else 
                    low = mid + 1;
            }
        }
        return -1;
    }
}