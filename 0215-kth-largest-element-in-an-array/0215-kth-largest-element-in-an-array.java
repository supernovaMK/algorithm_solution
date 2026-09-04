class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i:nums){

            queue.add(i);

            if(queue.size()>k){
                queue.poll();
            }
        }

        return queue.peek();

    }
}