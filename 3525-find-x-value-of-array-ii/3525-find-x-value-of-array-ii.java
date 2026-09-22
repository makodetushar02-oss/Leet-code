class Solution {
    private int[] treeProd;
    private int[][] treePref;
    private int k_val;
    private void merge(int parent, int left, int right) {
        treeProd[parent] = (treeProd[left] * treeProd[right]) % k_val;
        
        for (int i = 0; i < k_val; i++) {
            treePref[parent][i] = treePref[left][i];
        }
        
        for (int i = 0; i < k_val; i++) {
            if (treePref[right][i] > 0) {
                int newMod = (treeProd[left] * i) % k_val;
                treePref[parent][newMod] += treePref[right][i];
            }
        }
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int modVal = nums[l] % k_val;
            treeProd[node] = modVal;
            treePref[node][modVal] = 1;
            return;
        }
        
        int mid = l + (r - l) / 2;
        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);
        
        merge(node, 2 * node, 2 * node + 1);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int modVal = val % k_val;
            treeProd[node] = modVal;
            Arrays.fill(treePref[node], 0);
            treePref[node][modVal] = 1;
            return;
        }
        
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        
        merge(node, 2 * node, 2 * node + 1);
    }

    private int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            int[] res = new int[k_val + 1];
            res[0] = treeProd[node];
            for (int i = 0; i < k_val; i++) {
                res[i + 1] = treePref[node][i];
            }
            return res;
        }
        
        int mid = l + (r - l) / 2;
        if (qr <= mid) {
            return query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, r, ql, qr);
        }
        
        int[] leftRes = query(2 * node, l, mid, ql, qr);
        int[] rightRes = query(2 * node + 1, mid + 1, r, ql, qr);
        
        int[] res = new int[k_val + 1];
        res[0] = (leftRes[0] * rightRes[0]) % k_val;
        
        for (int i = 0; i < k_val; i++) {
            res[i + 1] = leftRes[i + 1];
        }
        
        for (int i = 0; i < k_val; i++) {
            if (rightRes[i + 1] > 0) {
                int newMod = (leftRes[0] * i) % k_val;
                res[newMod + 1] += rightRes[i + 1];
            }
        }
        
        return res;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.k_val = k;
        
        treeProd = new int[4 * n];
        treePref = new int[4 * n][k];
        
        build(1, 0, n - 1, nums);
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, idx, val);
            int[] qRes = query(1, 0, n - 1, start, n - 1);
            result[i] = qRes[x + 1]; 
        }
        
        return result;
    }
}