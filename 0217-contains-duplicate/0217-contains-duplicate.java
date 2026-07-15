class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(var k: nums){
            if(!set.add(k)){
                return true;
            }
        }
        return false;
    }
}