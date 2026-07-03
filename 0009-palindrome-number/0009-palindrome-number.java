class Solution {
    public boolean isPalindrome(int x) {
        int m = x ;
        int num = 0; 
        int z = 0;
        while(x < 0){
            return false;
        }
        while(x > 0){
                z = x%10;
                num = num*10 + z ;
                x = x/10;
        }
        return m == num ;
    }
}