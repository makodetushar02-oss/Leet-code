class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = nums[n - 1 - i];

        int[] dq = new int[n];      
        int head = 0, tail = 0;     
        long S = 0;                
        long total = 0;             
        long ans = 0;
        int L = 0;

        for (int R = 0; R < n; R++) {
            int x = b[R];
            total += x;

            
            while (tail > head && b[dq[tail - 1]] <= x) {
                int j = dq[--tail];
                int prev = (tail > head) ? dq[tail - 1] : L - 1;
                S += (long) (x - b[j]) * (j - prev);
            }
            dq[tail++] = R;
            S += x;
            while (S - total > k) {
                S -= b[dq[head]];
                total -= b[L];
                if (dq[head] == L) head++;
                L++;
            }

            ans += R - L + 1;
        }
        return ans;
    }
}