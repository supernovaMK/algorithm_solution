class Solution {
    int [] parent ;

    public int minCostConnectPoints(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(i!=j){
                    queue.offer(new int[]{i,j,manhattan(points[i],points[j])});
                }
            }
        }

        int totalCost =0;
        int count = points.length;
        int n = 0;
        parent = new int [points.length];

        for(int i=0;i<points.length;i++){
            parent[i] = i;
        }

        while(!queue.isEmpty()){
            int [] q = queue.poll();
            int a = q[0];
            int b = q[1];
            int distance = q[2];

            if(find(a)!=find(b)){
                
                union(a,b);
                totalCost +=distance;
                n++;

                if(n == count-1){
                    return totalCost;
                }

            }
        }

        return 0;
    }

    public int find(int a){
        if(parent[a]==a) return a;

        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        parent[parentB] = parentA;
    }

    public int manhattan(int[] a, int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}