class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long MOD = 1000000007;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new java.util.HashMap<>();
        
        long currentSumOfSquares = 0;
        long totalSum = 0;
        for (int j = 0; j < n; j++) {
            int x = nums[j];
            int prevIdx = lastSeen.getOrDefault(x, -1);
            long rangeLen = j - prevIdx;
            long sumVals = tree.querySum(1, 0, n - 1, prevIdx + 1, j);
            
            currentSumOfSquares = (currentSumOfSquares + 2 * sumVals + rangeLen) % MOD;
            tree.updateAdd(1, 0, n - 1, prevIdx + 1, j, 1);
            lastSeen.put(x, j);
            totalSum = (totalSum + currentSumOfSquares) % MOD;
        }
        return (int) totalSum;
    }
    
    static class SegmentTree {
        int n;
        long[] sumSq;
        long[] sumVal;
        long[] lazy;
        long MOD = 1000000007;
        
        public SegmentTree(int n) {
            this.n = n;
            sumSq = new long[4 * n];
            sumVal = new long[4 * n];
            lazy = new long[4 * n];
        }
        
        private void applyAdd(int node, int l, int r, long val) {
            long len = (r - l + 1);
            sumSq[node] = (sumSq[node] + 2 * val * sumVal[node] + val * val % MOD * len) % MOD;
            sumVal[node] = (sumVal[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }
        
        private void pushDown(int node, int l, int r) {
            if (lazy[node] != 0) {
                int mid = l + (r - l) / 2;
                applyAdd(2 * node, l, mid, lazy[node]);
                applyAdd(2 * node + 1, mid + 1, r, lazy[node]);
                lazy[node] = 0;
            }
        }
        
        private void pushUp(int node) {
            sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
            sumVal[node] = (sumVal[2 * node] + sumVal[2 * node + 1]) % MOD;
        }
        
        public void updateAdd(int node, int l, int r, int ql, int qr, long val) {
            if (ql > r || qr < l) return;
            if (ql <= l && r <= qr) {
                applyAdd(node, l, r, val);
                return;
            }
            pushDown(node, l, r);
            int mid = l + (r - l) / 2;
            updateAdd(2 * node, l, mid, ql, qr, val);
            updateAdd(2 * node + 1, mid + 1, r, ql, qr, val);
            pushUp(node);
        }
        public long querySum(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return 0;
            if (ql <= l && r <= qr) return sumVal[node];
            pushDown(node, l, r);
            int mid = l + (r - l) / 2;
            return (querySum(2 * node, l, mid, ql, qr) + querySum(2 * node + 1, mid + 1, r, ql, qr)) % MOD;
        }
    }
}