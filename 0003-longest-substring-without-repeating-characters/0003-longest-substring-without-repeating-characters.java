class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int max =0;
        int left = 0;
        int right = 0;

        Set<Character>  set = new HashSet<>();

        while(right<s.length()){
            if(set.add(s.charAt(right))){
                right++;
                max=Math.max(max,set.size());
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
      

        return max;
    }
}