class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return helper(piles, dp, suffixSum, 0, 1);
    }
    private int helper(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
        int n = piles.length;
        if (i == n) return 0;
        if (i + 2 * M >= n) return suffixSum[i];
        if (dp[i][M] != 0) return dp[i][M];
        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            int currentStones = suffixSum[i] - helper(piles, dp, suffixSum, i + x, Math.max(M, x));
            maxStones = Math.max(maxStones, currentStones);
        }
        dp[i][M] = maxStones;
        return maxStones;
    }
}