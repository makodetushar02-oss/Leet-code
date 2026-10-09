class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int rightNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                if (rightNeeded % 2 != 0) {
                    insertions++;
                    rightNeeded--;
                }
                rightNeeded += 2;
            } else {
                rightNeeded--;
                if (rightNeeded < 0) {
                    insertions++;
                    rightNeeded = 1;
                }
            }
        }
        
        return insertions + rightNeeded;
    }
}