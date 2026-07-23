class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * h);

            if (height[left] < height[right])
                left++;
            else {
                right--;
            }
        }

        return max;
    }
}