class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            int v = map.getOrDefault(word, 0);
            map.put(word, v + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                int f = a.freq - b.freq;
                if(f == 0)
                    return b.word.compareTo(a.word);
                return f;
            } 
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(pq.size() < k)
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            else if(entry.getValue() > pq.peek().freq) {
                pq.poll();
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            } else if(entry.getValue() == pq.peek().freq) {
                if(entry.getKey().compareTo(pq.peek().word) < 0){
                    pq.poll();
                    pq.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }
        LinkedList<String> ans = new LinkedList<>();
        while(!pq.isEmpty()) {
            Pair p = pq.peek();
            ans.addFirst(p.word);
            pq.poll();
        }
        return ans;
    }
    
    class Pair{
        String word;
        int freq;
        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}