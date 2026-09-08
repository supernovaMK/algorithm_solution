class Solution {
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    int n;
    int m;
    Deque<int[]> deque2;

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        deque2 = new ArrayDeque<>();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        while (!deque2.isEmpty()) {
            int[] k = deque2.poll();
            int hx = k[0];
            int hy = k[1];

            for (int i = 0; i < 4; i++) {
                int newX = hx + dx[i];
                int newY = hy + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0) {
                    grid[newX][newY] = grid[hx][hy] + 1;
                    deque2.add(new int[] { newX, newY });
                } else if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                    return grid[hx][hy] - 2;
                }
            }
        }
        return -1;
    }

    public void bfs(int x, int y, int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] { x, y });
        deque2.add(new int[] { x, y });
        grid[x][y] = 2;

        while (!deque.isEmpty()) {
            int[] k = deque.poll();
            int hx = k[0];
            int hy = k[1];

            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + hx;
                int newY = dy[i] + hy;

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                    deque.add(new int[] { newX, newY });
                    deque2.add(new int[] { newX, newY });
                    grid[newX][newY] = 2;
                }
            }
        }
    }
}