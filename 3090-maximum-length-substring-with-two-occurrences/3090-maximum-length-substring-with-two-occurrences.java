class Solution {
    public int maximumLengthSubstring(String s) {
    int[] freq = new int[26];
    int left = 0 ;
    int maxL = 0;
    for(int right = 0; right < s.length(); right++){
        char rightChar = s.charAt(right);
        freq[rightChar - 'a']++ ;
        while(freq[rightChar - 'a'] > 2){
            char leftChar = s.charAt(left);
            freq[leftChar - 'a']-- ;
            left++;
        }
        maxL = Math.max(maxL , right - left + 1);
    }
    return maxL ;
    }
}