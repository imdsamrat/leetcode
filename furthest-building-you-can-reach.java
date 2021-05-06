class Solution {
    public int furthestBuilding(int[] heights, int b, int r) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        for(int i = 1; i < heights.length; i++) {
            if(heights[i] > heights[i-1]) {
                pq.add(heights[i] - heights[i-1]);
                if(pq.size() > r)
                    b -= pq.poll();
                if(b < 0)
                    return i - 1;
            }
        }
        return heights.length - 1;
    }
}