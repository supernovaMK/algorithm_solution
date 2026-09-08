class Solution {
    public int maxDistance(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean foundLand = false;
        for(int i =0 ; i<n ; i++){
            for(int j = 0; j<m;j++){
                if(grid[i][j]==1)
                    deque.add(new int[]{i,j});
                    foundLand = true;

            }
        }

        if(foundLand == false){
            return -1;
        }
        int max = 0;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,-1,1};

        while(!deque.isEmpty()){
            int[] k = deque.poll();
            int x = k[0];
            int y = k[1];

            for(int i = 0;i<4;i++){
                int hx = dx[i]+x;
                int hy = dy[i]+y;

                if(hx>=0 && hx<n && hy>=0 && hy<m && grid[hx][hy]==0){
                    grid[hx][hy] = grid[x][y]+1;
                    max = Math.max(max,grid[hx][hy]);
                    deque.add(new int[]{hx,hy});
                }
            }
        }

        return max-1;
    }
}