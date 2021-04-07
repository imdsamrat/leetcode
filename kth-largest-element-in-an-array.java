class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}