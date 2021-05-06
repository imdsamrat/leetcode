class Solution {
    List<Integer> ans;
    int[] indegree;
    Map<Integer, List<Integer>> graph;
    int found;
    public int[] findOrder(int n, int[][] dep) {
        found = 0;
        graph = new HashMap<>();
        indegree = new int[n];
        for(int[] edge : dep) {
            int start = edge[0];
            int end = edge[1];
            
            graph.put(end, graph.getOrDefault(end, new ArrayList<>()));
            graph.get(end).add(start);
            indegree[start]++;
        }
        ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                dfs(i);
        }
        if(found == n)
        return ans.stream().mapToInt(i->i).toArray();
        return new int[0];
    }
    
    public void dfs(int i) {
        indegree[i]--;
        ans.add(i);
        found++;
        List<Integer> children = graph.get(i);
        if(children != null) {
            for(int child : children) {
                if(--indegree[child] == 0)
                    dfs(child);
            }
        }
    }
}