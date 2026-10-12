class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        
        
        int left = 0;
        int sum =0;
        int minCount = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            while(sum>=target){
                minCount = Math.min(minCount,i-left+1);

                sum-=nums[left];
                left++;
            }
        }
    if(minCount == Integer.MAX_VALUE) minCount =0;

    return minCount;
    }
}