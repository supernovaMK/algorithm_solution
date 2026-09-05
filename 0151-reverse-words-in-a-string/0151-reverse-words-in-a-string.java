class Solution {
    public String reverseWords(String s) {
        s.trim();
        String[] stt = s.split("\\s+");
        StringBuilder st = new StringBuilder();
        for(int i=stt.length-1;i>=0;i--){
        st.append(stt[i]).append(" ");
        }
        return st.toString().trim();
    }
}