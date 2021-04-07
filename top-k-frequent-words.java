class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            int v = map.getOrDefault(word, 0);
            map.put(word, v + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2)  == 0 ? n2.compareTo(n1) : map.get(n1) - map.get(n2)
        );
        for(String entry : map.keySet()) {
            pq.add(entry);
            if(pq.size() > k)
                pq.poll();
        }
        LinkedList<String> ans = new LinkedList<>();
        while(!pq.isEmpty()) {
            ans.addFirst(pq.poll());
        }
        return ans;
    }
}