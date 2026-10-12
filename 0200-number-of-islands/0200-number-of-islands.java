class Solution {
    int n, m;
    boolean [][] visited;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]=='1' && visited[i][j]==false){
                    bfs(i,j,grid);
                    count++;
                }
            }

        }
        return count;
    }

    public void bfs(int x, int y, char[][] grid){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{x,y});
        visited[x][y] = true;
        
        while(!deque.isEmpty()){
            int[] xy = deque.poll();
            int xx = xy[0];
            int yy = xy[1];

            for(int i=0;i<4;i++){
                int hx = xx+ dx[i];
                int hy = yy+ dy[i];

                if(hx<0||hx>=n||hy<0||hy>=m){
                    continue;
                }

                if(visited[hx][hy]==true|| grid[hx][hy]!='1') continue;
                
                deque.offer(new int[]{hx,hy});
                visited[hx][hy] = true;

            }
        }

    }
}