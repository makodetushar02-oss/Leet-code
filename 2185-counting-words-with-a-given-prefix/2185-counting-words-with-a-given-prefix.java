class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String temp : words) {
            if (temp.startsWith(pref)) {
                count++;
            }
        }
        return count ;  
    }
}