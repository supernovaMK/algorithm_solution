class Solution {

    boolean[] visited;
    int n;
    List<Integer> list;
    List<List<Integer>> answer;

    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        visited = new boolean[nums.length];
        n = nums.length;
        list = new ArrayList<>();

        permutations(nums);

        return answer;
    }

    public void permutations(int[] nums) {

        if (list.size() == n) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                list.add(nums[i]);
                visited[i] = true;

                permutations(nums);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}