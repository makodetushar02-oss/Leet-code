    class Solution {
    int[] count = new int[26];
    char[] ans;
    char[] targetArr;
    int n;
    public String lexGreaterPermutation(String s, String target) {
        n = s.length();
        ans = new char[n];
        targetArr = target.toCharArray();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        if (dfs(0, true)) {
            return new String(ans);
        }
        return "";
    }
    private boolean dfs(int index, boolean isTight) {
        if (index == n) {
            return !isTight; 
        }
        if (!isTight) {
            for (int j = 0; j < 26; j++) {
                if (count[j] > 0) {
                    count[j]--;
                    ans[index] = (char)(j + 'a');
                    dfs(index + 1, false);
                    return true; 
                }
            }
        } else {
            int targetChar = targetArr[index] - 'a';
            if (count[targetChar] > 0) {
                count[targetChar]--;
                ans[index] = targetArr[index];
                if (dfs(index + 1, true)) {
                    return true;
                }
                count[targetChar]++;
            }
            for (int j = targetChar + 1; j < 26; j++) {
                if (count[j] > 0) {
                    count[j]--;
                    ans[index] = (char)(j + 'a');
                    dfs(index + 1, false); 
                    return true;
                }
            }
        }   
        return false;
    }
}
    