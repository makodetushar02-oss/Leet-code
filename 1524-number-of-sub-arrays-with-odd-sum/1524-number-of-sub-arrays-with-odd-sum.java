class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long odd = 0, even = 1, ans = 0;
        int prefix = 0;
        for (int x : arr) {
            prefix += x;
            if (prefix % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
            ans %= MOD;
        }
        return (int) ans;
    }
}