class Solution {
    public int reverseDegree(String s) {
        int reverseDegreeSum = 0;
        for(int i = 0; i< s.length() ; i++){
            int StringPosition = i+1;
            int reversedAlphaPosition = 26 -(s.charAt(i) - 'a');
            reverseDegreeSum += StringPosition * reversedAlphaPosition; 
        }
        return reverseDegreeSum;
    }
}