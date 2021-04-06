AWS CloudFront wants to build an algo to measure the efficiency of its caching network. The network is represented as a number of nodes and a list of connected pairs. The efficiency of this network can be estimated by first summing the cost of each isolated set of nodes where each individual node has a cost of 1. To account for the increase in efficiency as more nodes are connected, update the cost of each isolated set to be the ceiling of the square root of the original cost and return the final sum of all costs.

Example:
n = 10 nodes
edges = [[1 2] , [1 3] , [2 4] , [3 5] , [7 8]]

There are 2 isloated sets with more than one node {1,2,3,4,5} and {7,8}. The ceilings of their square roots are:
5^1/2 = 2.236 and ceil(2.236) = 3
2^1/2 = 1.414 and ceil(1.414) = 2

The other three isolated nodes are separate and the square root of their weights is 1^1/2 = 1 respectively.
The sum is 3+2+(3*1) = 8

Function Description
Complete the function connectedSum in the editor below

connectedSum has the following parameter(s):
int n: the number of nodes
str edges[m]: an array of strings that consist of a space-separated integer pain that denotes two connected nodes, p and q

Returns:
int: an integer that denotes the sum of the values calculated

Constraints:

2 <= n <= 10^5
1 <= m <=10^5
1 <= p,q <= n
p != n
Sample Input 0
n = 4 nodes
edges[] size m = 2
edges[] = [[1 2], [1 4]]

Sample Output 0
3

Explanation 0
The values to sum are:

Set {1,2,4}: c =ceil(sqrt(3)) = 2
Set {3}: c = ceil(sqrt(1)) = 1
2+1=3

Sample Input 1
n = 8 nodes
edges[] size m = 4
edges[] = [[8 1], [5 8], [7 3], [8 6]]

Sample Output 1
6

Explanation 1
The values to sum for each group are:

Set {2}: c =ceil(sqrt(1)) = 1
Set {4}: c = ceil(sqrt(1)) = 1
Set {1,5,6,8}: c = ceil(sqrt(4)) = 2
Set {3,7}: c = ceil(sqrt(2)) = 2
1+1+2+2 = 6

```java
// "static void main" must be defined in a public class.
class Solution {
    private int doBFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            if (!g.containsKey(cur)) continue;
            for (int next : g.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return (int)(Math.ceil(Math.sqrt(cnt)));
    }
    public int getEfficiencyOfCloudFrontCaching(int N, int[][] edges) {
        g = new HashMap<>();
        visited = new boolean[N];
        for (int i=0; i<edges.length; ++i) {
            int src = edges[i][0]-1, dest = edges[i][1]-1;
            if (!g.containsKey(src)) g.put(src, new ArrayList<>());
            if (!g.containsKey(dest)) g.put(dest, new ArrayList<>());
            g.get(src).add(dest);
            g.get(dest).add(src);
        }

        int res = 0;
        for (int i=0; i<N; ++i) {
            if (!visited[i]) res += doBFS(i);
        }
        return res;
    }
    Map<Integer, List<Integer>> g;
    boolean[] visited;
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {7, 8}};
        System.out.println(sol.getEfficiencyOfCloudFrontCaching(10, edges1));
        int[][] edges2 = {{1, 2}, {1, 4}};
        System.out.println(sol.getEfficiencyOfCloudFrontCaching(4, edges2));
        int[][] edges3 = {{8, 1}, {5, 8}, {7, 3}, {8, 6}};
        System.out.println(sol.getEfficiencyOfCloudFrontCaching(8, edges3));
    }
}
```