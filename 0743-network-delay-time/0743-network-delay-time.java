class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        
        for(int i = 1;i<=n;i++){
            map.putIfAbsent(i,new ArrayList<>());
        }
        
        for(var time:times){
            map.get(time[0]).add(new int[]{time[1],time[2]});
        }

        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        queue.offer(new int[]{k,0});
        dist[k] = 0 ;

        while(!queue.isEmpty()){
            int []q = queue.poll();
            int q1 = q[0];
            int q2 = q[1];
            if(dist[q1]<q2) continue;
            for(var m:map.get(q1)){
                int a = m[0];
                int b= m[1];
                
                if(dist[a]>dist[q1]+b) {dist[a] = dist[q1]+b;
                queue.offer(new int[]{a,dist[a]});}
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            answer = Math.max(answer,dist[i]);
        }

        return answer!=Integer.MAX_VALUE?answer:-1;
    }
}