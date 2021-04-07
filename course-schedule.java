class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            if(!graph.containsKey(b)) graph.put(b, new ArrayList<>());
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int found = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            
            List<Integer> child = graph.get(temp);
            if(child != null) {
                for(int a : child) {
                    indegree[a]--;
                    if(indegree[a] == 0)
                    q.add(a);
                }
            }
            found++;
        }
        return found == numCourses;
    }
}