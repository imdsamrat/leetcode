class Solution {
    Map<Integer, List<Integer>> graph;
    int[] ans;
    int idx;
    boolean[] visited;
    boolean[] visiting;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        for(int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            if(!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            graph.get(a).add(b);
        }
        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if(isCyclic(i))
                return new int[0];
        }
        visited = new boolean[numCourses];
        ans = new int[numCourses];
        idx = 0;
        for(int i = 0; i < numCourses; i++) {
            topoDFS(i);
        }
        return ans;
    }
    
    public void topoDFS(int n) {
        if(visited[n])
            return;
        visited[n] = true;
        List<Integer> children = graph.get(n);
        if(children != null) {
            for(int child : children)
                topoDFS(child);
        }
        ans[idx++] = n;
    }
    
    public boolean isCyclic(int n) {
        if(visiting[n])
            return true;
        if(visited[n])
            return false;
        visiting[n] = true;
        visited[n] = true;
        
        List<Integer> children = graph.get(n);
        if(children != null) {
            for(int child : children) {
                if(isCyclic(child))
                    return true;
            }
        }
        visiting[n] = false;
        return false;
    }
    
}