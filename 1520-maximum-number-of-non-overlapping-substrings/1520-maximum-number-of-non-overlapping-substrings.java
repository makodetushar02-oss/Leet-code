class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (left[c] == -1) left[c] = i;
            right[c] = i;
        }

        List<String> result = new ArrayList<>();
        int lastRight = -1;
        for (int i = 0; i < n; i++) {
           
            if (i == left[s.charAt(i) - 'a']) {
                int newRight = check(s, i, left, right);
                
                if (newRight != -1) {
                    if (i > lastRight) {
                        result.add("");
                    }
                    lastRight = newRight;
                    result.set(result.size() - 1, s.substring(i, lastRight + 1));
                }
            }
        }
        
        return result;
    }

    private int check(String s, int i, int[] left, int[] right) {
        int rightBound = right[s.charAt(i) - 'a'];
        for (int j = i; j <= rightBound; j++) {
            if (left[s.charAt(j) - 'a'] < i) {
                return -1; 
            }
            rightBound = Math.max(rightBound, right[s.charAt(j) - 'a']);
        }
        return rightBound;
    }
}