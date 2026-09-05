class Solution {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount =0;
        Deque<int[]> deque = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2) deque.add(new int[]{i,j});
                else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }


        if(freshCount==0) return 0;

        int days = 0;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};

        while(!deque.isEmpty()){
            int dequeSize = deque.size();
            boolean found = false;
            for(int i=0;i<dequeSize;i++){
                int[] dot = deque.poll();
                int x = dot[0];
                int y = dot[1];

                for(int j =0 ; j<4;j++){
                    
                    int hx = dx[j]+x;
                    int hy= dy[j]+y;

                    if(hx>=n||hx<0||hy>=m||hy<0) continue;
                    if(grid[hx][hy]==1){
                        deque.add(new int[]{hx,hy});
                        grid[hx][hy]=2;
                        found = true;
                        freshCount--;
                    }
                }
            }

            if(!found) break;

            found = false;
            days++;
        }

        if(freshCount>0) return -1;
        return days;
    }
}