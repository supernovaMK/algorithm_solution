class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int n : set) {
            if(set.contains(n-1)) continue;
            int copyN = n+1;
            int count = 1;
            while (true) {
                if (set.contains(copyN)) {
                    copyN++;
                    count++;
                }else{
                    maxCount = Math.max(maxCount,count);
                    count=0;
                    break;
                }
            }
        }
        return maxCount;
    }
}