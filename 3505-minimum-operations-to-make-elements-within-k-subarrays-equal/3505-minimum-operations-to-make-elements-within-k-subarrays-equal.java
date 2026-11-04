class Solution {
    int m;
    long[] cnt, sum;

    void update(int i, long c, long v) {
        for (; i <= m; i += i & -i) { cnt[i] += c; sum[i] += v; }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] vals = Arrays.stream(nums).distinct().sorted().toArray();
        m = vals.length;
        cnt = new long[m + 1];
        sum = new long[m + 1];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[i] = Arrays.binarySearch(vals, nums[i]) + 1;

        int LOG = Integer.highestOneBit(m);
        int need = (x + 1) / 2;            
        long[] cost = new long[n - x + 1];
        long total = 0;

        for (int i = 0; i < n; i++) {
            update(rank[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                update(rank[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                int pos = 0;
                long c = 0, s = 0;
                for (int step = LOG; step > 0; step >>= 1) {
                    int np = pos + step;
                    if (np <= m && c + cnt[np] < need) {
                        pos = np;
                        c += cnt[np];
                        s += sum[np];
                    }
                }
                int idx = pos + 1;         
                long med = vals[idx - 1];
                long cntLE = c + (query(cnt, idx) - query(cnt, idx - 1));
                long sumLE = s + (query(sum, idx) - query(sum, idx - 1));
                cost[i - x + 1] = med * cntLE - sumLE + (total - sumLE) - med * (x - cntLE);
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];       
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = x; i <= n; i++) {
                cur[i] = cur[i - 1];
                if (prev[i - x] < INF)
                    cur[i] = Math.min(cur[i], prev[i - x] + cost[i - x]);
            }
            prev = cur;
        }
        return prev[n];
    }

    long query(long[] t, int i) {
        long r = 0;
        for (; i > 0; i -= i & -i) r += t[i];
        return r;
    }
}