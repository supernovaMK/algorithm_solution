class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        function(nums,0);
        return list;
    }

    public void function(int[]nums,int start){
        if(tmp.size()==nums.length){
            list.add(List.copyOf(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==true) continue;

            tmp.add(nums[i]);
            visited[i]=true;
            function(nums,i+1);
            tmp.remove(tmp.size()-1);
            visited[i]=false;
        }
    }
}