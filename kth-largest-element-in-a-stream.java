class KthLargest {

    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i< nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
        } else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */