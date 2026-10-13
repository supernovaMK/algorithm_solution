class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        if(nums.length>=2)
        dp[2] = Math.max(nums[1],dp[1]);
        else return nums[0];
        int max =0;

        
        for(int i=1;i<nums.length;i++){
            dp[i+1]= Math.max(dp[i],dp[i-1]+nums[i]);
            if(max<dp[i+1]){
                max = dp[i+1];
            }
        }
        
        return max;
    }
}