class Solution {
    public char findTheDifference(String s, String t) {
        int[] bitmap = new int[26];
        for(int i = 0 ; i< s.length();i++ ){
        char ch = s.charAt(i);
        bitmap[ch - 97]++;
        } 
        for(int  i = 0; i< t.length(); i++){
        char ch = t.charAt(i);
        bitmap[ch - 97]--;
        }
        for(int  i = 0; i<26; i++){
        if(bitmap[i] != 0) return (char)(i + 97);
        }
        return ' ';
    }
}