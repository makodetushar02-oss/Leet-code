class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }
        
        long maxSum = 0;
        long MOD = 1_000_000_007;
        
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int j = 0; j < 32; j++) {
                if (bitCounts[j] > 0) {
                    currentNum |= (1L << j);
                    bitCounts[j]--;
                }
            }
            maxSum = (maxSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) maxSum;
    }
}