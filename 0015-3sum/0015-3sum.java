class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int k = nums[i];
            int left = i+1;
            int right=nums.length-1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(left<right){
                if(nums[left]+nums[right]>-k){
                    right--; continue;
                }else if(nums[left]+nums[right]<-k){
                    left++; continue;
                }else{
                    answer.add(Arrays.asList(k, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                    continue;
                }
            }
        }


        return answer;

    }
}