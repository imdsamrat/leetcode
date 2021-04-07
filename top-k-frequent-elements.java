class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2)
        );
        for(int n : map.keySet()) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }
}