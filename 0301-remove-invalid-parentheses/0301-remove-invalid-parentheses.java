class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, left, right, res);
        return res;
    }

    private void dfs(String s, int start, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (left + right > s.length() - i) return;

            char c = s.charAt(i);
            String next = s.substring(0, i) + s.substring(i + 1);
            if (c == '(' && left > 0) {
                dfs(next, i, left - 1, right, res);
            } else if (c == ')' && right > 0) {
                dfs(next, i, left, right - 1, res);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (--count < 0) return false;
            }
        }
        return count == 0;
    }
}