class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
            int k = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < -k) {
                    left++;
                } else if (nums[left] + nums[right] > -k) {
                    right--;
                } else {
                    answer.add(Arrays.asList(k, nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
        left++;
    }

                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }

        }

        return answer;
    }
}