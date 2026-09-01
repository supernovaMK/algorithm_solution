class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right =0;
        int maxSize =0;
        Set<Character>set = new HashSet<>();

        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }else{
                maxSize = Math.max(maxSize,right-left+1);
                set.add(s.charAt(right));
                right++;
            }
        }
        return maxSize;
        
    }
}