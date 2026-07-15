class Solution {
    public boolean checkIfPangram(String sentence) {
       if (sentence.length() < 26) {
            return false;
        }
        int seen = 0;
        for (int i = 0; i < sentence.length(); i++) {
            seen |= (1 << (sentence.charAt(i) - 'a'));
            if (seen == (1 << 26) - 1) {
                return true;
            }
        }
        return false;
    }
}