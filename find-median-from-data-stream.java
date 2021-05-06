class MedianFinder {

    /** initialize your data structure here. */
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if (num > maxHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        while(maxHeap.size() + 1 > minHeap.size()) {
            int temp = maxHeap.poll();
            minHeap.add(temp);
        }
        while(maxHeap.size() < minHeap.size()) {
            int temp = minHeap.poll();
            maxHeap.add(temp);
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek())/ 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */