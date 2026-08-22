class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long[] lcms = new long[1 << n];
        int[] bits = new int[1 << n];
        for (int mask = 1; mask < (1 << n); mask++) {
            int lsb = mask & (-mask);
            int idx = Integer.numberOfTrailingZeros(lsb);
            int prevMask = mask ^ lsb;
            if (prevMask == 0) {
                lcms[mask] = coins[idx];
                bits[mask] = 1;
            } else {
                lcms[mask] = lcm(lcms[prevMask], coins[idx]);
                bits[mask] = bits[prevMask] + 1;
            }
        }
        long lo = 1, hi = (long) getMin(coins) * k;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countLE(mid, lcms, bits, n) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    private long countLE(long x, long[] lcms, int[] bits, int n) {
        long total = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long l = lcms[mask];
            if (l > x) continue; 
            long term = x / l;
            if (bits[mask] % 2 == 1) {
                total += term;
            } else {
                total -= term;
            }
        }
        return total;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    private int getMin(int[] coins) {
        int m = Integer.MAX_VALUE;
        for (int c : coins) m = Math.min(m, c);
        return m;
    }
}