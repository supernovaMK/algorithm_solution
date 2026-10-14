class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(var time:times){
            int u = time[0];
            int t = time[1];
            int l = time[2];

            map.putIfAbsent(u,new ArrayList<>());
            
            map.get(u).add(new int[]{t,l});
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(k);

        int [] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            List<int[]> nowList  = map.get(now);
            if (nowList == null) continue;
            for(var nl:nowList){
                if(distance[nl[0]]>distance[now]+nl[1]){
                    distance[nl[0]] = distance[now]+nl[1];
                    queue.offer(nl[0]);
                }
            }
        }
        int answer = 0;

        for(int i=1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE) return -1;
            answer =  Math.max(answer,distance[i]);
        }

        return answer;
    }
}