class Solution {
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        int[] arr = {2,3,5};
        for(int ans : arr){
            while(n % ans == 0){
                n/=ans ;
            }
        }
        return n == 1;
    }
}