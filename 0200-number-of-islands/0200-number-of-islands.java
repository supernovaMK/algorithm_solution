class Solution {
    boolean[][] visited;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(int xi, int yi,char[][] grid ) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] { xi, yi });
        int[] dx = new int[] { 1, -1, 0, 0 };
        int[] dy = new int[] { 0, 0, 1, -1 };
        int count = 0;

        while (!deque.isEmpty()) {
            int[] point = deque.pop();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int hx = x + dx[i];
                int hy = y + dy[i];

                if (hx < 0 || hx >= m || hy < 0 || hy >= n)
                    continue;
                if (visited[hx][hy] || grid[hx][hy] == '0')
                    continue;

                deque.offer(new int[] { hx, hy });
                visited[hx][hy]=true;
            }
        }
    }
}