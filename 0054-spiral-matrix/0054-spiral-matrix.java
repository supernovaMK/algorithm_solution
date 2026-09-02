class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = 0;
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        int idx = 0;
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();

        while (true) {
            visited[i][j]=true;
            list.add(matrix[i][j]);
            boolean k = false;

            for (int i2 = 0; i2 < 4; i2++) {
                if (i + dx[idx] >= n || i + dx[idx] < 0 || j + dy[idx] >= m || j + dy[idx] < 0 || visited[i + dx[idx]][j + dy[idx]]) {
                    idx++;
                    idx %= 4;
                } else {
                    k=true;
                    break;
                }
            }

            if(!k) return list;
            
            i+=dx[idx];
            j+=dy[idx];
        }
    }
}