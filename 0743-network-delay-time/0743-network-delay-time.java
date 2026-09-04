class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new int[] { time[1], time[2] });
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] { k, 0 });

        while (!queue.isEmpty()) {
            int[] vi = queue.poll();
            int currentNode = vi[0];
            int totalTime = vi[1];

            if (totalTime > distance[currentNode])
                continue;

            List<int[]> list = graph.get(currentNode);

            for (int[] array : list) {
                if (distance[array[0]] > totalTime + array[1]) {
                    distance[array[0]] = totalTime+array[1];
                    queue.add(new int[] { array[0], array[1] + totalTime });
                }
            }

        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, distance[i]);
        }
        return maxTime;
    }
}