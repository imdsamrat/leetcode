class Solution {
    
    class Node {
		int val;
		int i, j;

		Node(int val, int i, int j) {
			this.val = val;
			this.i = i;
			this.j = j;
		}
	}

	class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node x, Node y) {
			return x.val - y.val;
		}
	}
    
    public int trapRainWater(int[][] heightMap) {
		Comparator<Node> comparator = new NodeComparator();
		int r = heightMap.length;
		int c = heightMap[0].length;
		boolean[][] visited = new boolean[r][c];
		PriorityQueue<Node> pq = new PriorityQueue<Node>(comparator);
		for (int i = 0; i < r; i++) {
			pq.add(new Node(heightMap[i][0], i, 0));
			visited[i][0] = true;
			pq.add(new Node(heightMap[i][c - 1], i, c - 1));
			visited[i][c - 1] = true;
		}
		for (int i = 1; i < c - 1; i++) {
			pq.add(new Node(heightMap[0][i], 0, i));
			visited[0][i] = true;
			pq.add(new Node(heightMap[r - 1][i], r - 1, i));
			visited[r - 1][i] = true;
		}
		int maxh = Integer.MIN_VALUE;
		int ans = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			maxh = Math.max(maxh, node.val);
			int row = node.i;
			int col = node.j;
			if (col - 1 >= 0 && !visited[row][col - 1]) {
				pq.add(new Node(heightMap[row][col - 1], row, col - 1));
				visited[row][col - 1] = true;
				ans += Math.max(maxh - heightMap[row][col - 1], 0);
			}
			if (col + 1 < c && !visited[row][col + 1]) {
				pq.add(new Node(heightMap[row][col + 1], row, col + 1));
				visited[row][col + 1] = true;
				ans += Math.max(maxh - heightMap[row][col + 1], 0);
			}
			if (row - 1 >= 0 && !visited[row - 1][col]) {
				pq.add(new Node(heightMap[row - 1][col], row - 1, col));
				visited[row - 1][col] = true;
				ans += Math.max(maxh - heightMap[row - 1][col], 0);
			}
			if (row + 1 < r && !visited[row + 1][col]) {
				pq.add(new Node(heightMap[row + 1][col], row + 1, col));
				visited[row + 1][col] = true;
				ans += Math.max(maxh - heightMap[row + 1][col], 0);
			}
		}
		return ans;
	}
}