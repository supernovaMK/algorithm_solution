class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (maps.containsKey(target - numbers[i])) {
                return new int[] { maps.get(target - numbers[i])+1, i+1 };
            } else {
                maps.put(numbers[i], i);
            }
        }

        return new int[]{};
    }
}