class Solution {
    public boolean strongPasswordCheckerII(String password) {
       if( password.length() < 8) return false ;
       boolean  isLower = false ;
       boolean  isUpper = false ;
       boolean  isDigit = false ;
       boolean  isSpetial = false ;
       String s = "!~@#$%^&*()_+-*";
       for(int i =0; i< password.length() ;i++){
        if(i < password.length() - 1 && password.charAt(i) == password.charAt(i+1)){
            return false ;
        }
        char ch = password.charAt(i);
        if(Character.isLowerCase(ch)) isLower = true ;
        if(Character.isUpperCase(ch)) isUpper = true ;
        if(Character.isDigit(ch)) isDigit = true ;
        if(s.indexOf(ch) != -1) isSpetial = true ;
       }
       return isLower && isUpper && isDigit &&  isSpetial;
    }
}