class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        return median(nums1, nums2, 0, nums1.length);
    }
    
    public double median(int[] x, int[] y, int low, int high) {
        if(low <= high) {
            int midX = low + (high - low) / 2;
            int midY = (x.length + y.length + 1) / 2 - midX;
            
            if(midX < high && x[midX] < y[midY - 1])
            return median(x, y, midX + 1, high);
            
            if(midX > low  && x[midX - 1] > y[midY])
                return median(x, y, low, midX - 1);
            
            
            else {
                double maxLeft = 0;
                if(midX == 0) { maxLeft = y[midY - 1]; }
                else if(midY == 0) { maxLeft = x[midX - 1]; }
                else { maxLeft = Math.max(x[midX - 1], y[midY - 1]); }
                
                boolean even = (x.length + y.length) % 2 == 0 ? true : false;
                if(!even)
                   return maxLeft;
                
                double minRight = 0;
                if(midX == x.length) { minRight = y[midY]; }
                else if(midY == y.length) { minRight = x[midX]; }
                else { minRight = Math.min(x[midX], y[midY]); }
                
                return (maxLeft + minRight) / 2;
            }
        }
        return 0.0;
    }
    
}