class Solution {
    
    int r, c;
    boolean[][] visited;
    public void solve(char[][] board) {
        int N = 4;
        int[] xMove = new int[] {0, 1, 0, -1};
        int[] yMove = new int[] {1, 0, -1, 0};
        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];
        Queue<Node> q = new LinkedList<Node>();
        // add vertical boundary to the queue
        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O') {
                q.add(new Node(i, 0));
                visited[i][0] = true;
            }
            if(board[i][c - 1] == 'O') {
                q.add(new Node(i, c - 1));
                visited[i][c - 1] = true;
            }
        }
        // add horizontal boundary to the queue
        for(int i = 1; i < c - 1; i++) {
            if(board[0][i] == 'O') {
                q.add(new Node(0, i));
                visited[0][i] = true; 
            }
            if(board[r - 1][i] == 'O') {
                q.add(new Node(r - 1, i));
                visited[r - 1][i] = true;
            }
        }
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for(int i = 0; i < N; i++) {
                int nextX = temp.x + xMove[i];
                int nextY = temp.y + yMove[i];
                if(isSafe(board, nextX, nextY)) {
                    q.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        for(int i = 1; i < r - 1; i++) {
            for(int j = 1; j < c - 1; j++){
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    
    public boolean isSafe(char[][] board, int x, int y) {
        return x >= 0 && x < r
            && y >= 0 && y < c
            && !visited[x][y]
            && board[x][y] == 'O';
    }
    
}

class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}