class Solution {
    static final int MOD = 1000000007;
    static final int LIMIT = 2000; 
    static long[] fact = new long[LIMIT];
    static long[] inv = new long[LIMIT];

    static {
        fact[0] = 1;
        for (int i = 1; i < LIMIT; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        
        inv[LIMIT - 1] = pow(fact[LIMIT - 1], MOD - 2);
        
        for (int i = LIMIT - 1; i > 0; i--) {
            inv[i - 1] = inv[i] * i % MOD;
        }
    }
    private static long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) res = res * base % MOD;
            base = base * base % MOD;
            exp /= 2;
        }
        return res;
    }

    private long comb(int n, int r) {
        if (n < r) return 0;
        return fact[n] * inv[r] % MOD * inv[n - r] % MOD;
    }
    public int numberOfSets(int n, int k) {
        return (int) comb(n + k - 1, k * 2);
    }
}