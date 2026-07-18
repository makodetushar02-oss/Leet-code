class Solution {
    public boolean isPalindrome(String s) {
        int l =0;
        int r = s.length() - 1;
        while(l < r){
            char charl = s.charAt(l);
            char charr = s.charAt(r);
            if(!Character.isLetterOrDigit(charl)){
                l++;
            }else if(!Character.isLetterOrDigit(charr)){
                r--;
            }
            else{
                if(Character.toLowerCase(charl) != Character.toLowerCase(charr)){
                    return false; 
                }
                r--;
                l++;
            }
        }
        return true ;
    }
}