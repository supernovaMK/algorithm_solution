class Solution {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;

        int leftMax=height[0];
        int rightMax=height[right];

        int sum =0;
        while(left<right){
            if(leftMax<=rightMax){
                sum+=leftMax-height[left];
                left++;
                leftMax=Math.max(leftMax,height[left]);
            }else{
                sum+=rightMax-height[right];
                right--;
                rightMax=Math.max(rightMax,height[right]);
            }

        }

        return sum;
    }
}