class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] current = new long[k]; 
        long[] next = new long[k];    
        
        int[] active1 = new int[k];
        int[] active2 = new int[k];
        int[] active = active1;
        int[] nextActive = active2;
        int activeCount = 0;
        boolean[] seen = new boolean[k];
        
        for (int num : nums) {
            int nextActiveCount = 0;
            
            long val = num % k;
            int startR = (int) val;
            
            next[startR]++;
            seen[startR] = true;
            nextActive[nextActiveCount++] = startR;
            
            for (int i = 0; i < activeCount; i++) {
                int r = active[i];
                int nextR = (int) ((r * val) % k); 
                
                next[nextR] += current[r];
                
                if (!seen[nextR]) {
                    seen[nextR] = true;
                    nextActive[nextActiveCount++] = nextR;
                }
                current[r] = 0;
            }
            
            for (int i = 0; i < nextActiveCount; i++) {
                int r = nextActive[i];
                ans[r] += next[r];
                
                current[r] = next[r];
                next[r] = 0;
                seen[r] = false;
            }
            int[] temp = active;
            active = nextActive;
            nextActive = temp;
            activeCount = nextActiveCount;
        }
        return ans;
    }
}