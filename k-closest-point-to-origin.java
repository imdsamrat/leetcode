class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) < (a[0]*a[0] + a[1]*a[1]) ? -1 : 1);
        for(int[] point : points) {
            pq.add(point);
            if(pq.size() > k)
                pq.poll();
        }
        List<int[]> ans =  new ArrayList<>();
        for(int[] a : pq) {
            ans.add(a);
        }
        return ans.toArray(new int[pq.size()][]);
    }
}