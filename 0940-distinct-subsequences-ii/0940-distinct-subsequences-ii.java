class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] end = new int[26];
        int total = 0;

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            int added = (total + 1 - end[i]) % MOD;
            if (added < 0) {
                added += MOD;
            }
            total = (total + added) % MOD;
            end[i] = (end[i] + added) % MOD;
        }
        return total;
    }
}