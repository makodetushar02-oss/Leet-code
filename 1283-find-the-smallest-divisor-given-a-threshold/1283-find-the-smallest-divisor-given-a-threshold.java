class Solution {
    public int smallestDivisor(int[] piles, int h ) {
        int start=1, end=0;
        for(int e : piles){
            start = Math.min(e, start);
            end = Math.max(e, end);
        }
        int ans=-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if (isValid(piles, h, mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean isValid(int[] piles, int hours, int capacity) {
        int curH = 0;
        for (int pile : piles) {
            curH += Math.ceil(pile*1.0/capacity);
        }
        return curH <= hours;
    }
}
   