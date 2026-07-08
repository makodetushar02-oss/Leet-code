class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false ;
        }
       int n = s.length();
       for(int i = 0 ; i< n ; i++){
        boolean isMatch = true ;
        for(int j = 0 ; j< n; j++){
            if(s.charAt((i + j)% n) != goal.charAt(j)){
                isMatch = false ;
                break;
            }
        }
        if(isMatch){
                return true ;
            }
       }
        return false ;
    }
}