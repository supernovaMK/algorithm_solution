class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Count = 0;
        int word2Count = 0;
        StringBuilder answer = new StringBuilder();

        while (word1Count < word1.length() || word2Count < word2.length()) {
            if (word1Count < word1.length()) {
                answer.append(word1.charAt(word1Count));
                word1Count++;
            }
            if (word2Count < word2.length()) {
                answer.append(word2.charAt(word2Count));
                word2Count++;
            }
        }
        return answer.toString();
    }
}