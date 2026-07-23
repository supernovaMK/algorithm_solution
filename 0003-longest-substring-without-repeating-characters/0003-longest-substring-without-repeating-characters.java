class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        
        char[] str = s.toCharArray();
        int max = 1;
        for (int i = 1; i < str.length; i++) {
            int now = 1;
            Set<Character> set = new HashSet<>();
            set.add(str[i]);
            int k = i;
            while (k >= 1) {
                if (set.add(str[k - 1])) {
                    now += 1;
                    k -= 1;
                } else {
                    break;
                }
            }

            max = Math.max(max, now);
        }

        return max;
    }
}