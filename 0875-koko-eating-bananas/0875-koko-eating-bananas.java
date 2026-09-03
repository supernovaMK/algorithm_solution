class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int mid = 0;
        int answer =0;
        for (int i : piles) {
            right = Math.max(right, i);
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (can(mid,piles,h)) {
                answer = mid;
                right = mid - 1;
            } else {
                left=mid+1;
            }
        }
        return answer;
    }

    public boolean can(int mid,int[]piles,int h) {
        long count =0;
        for(int i:piles){
            count+=i/mid;
            if(i%mid!=0){
                count+=1;
            }
        }

        if(count<=h) return true;
        return false;
    }
}