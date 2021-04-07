class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b) {
                return a.freq - b.freq;
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            int v = map.getOrDefault(n, 0);
            map.put(n, v + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(pq.size() < k)
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            else if(entry.getValue() > pq.peek().freq) {
                pq.poll();
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        int[] ans = new int[pq.size()];
        int i = 0;
        for(Pair p : pq) {
            ans[i++] = p.val;
        }
        return ans;
    }
    
    class Pair{
        int freq;
        int val;
        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
}