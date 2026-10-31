class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0][0] = 1;
                    dp[0][0][1] = 1;
                    continue;
                }
                long R = (j > 0) ? dp[i][j - 1][0] : 0; 
                long D = (i > 0) ? dp[i - 1][j][1] : 0; 

                if (grid[i][j] == 0) {
                    long totalWays = (R + D) % MOD;
                    dp[i][j][0] = totalWays;
                    dp[i][j][1] = totalWays;
                } else {
                    dp[i][j][0] = D;
                    dp[i][j][1] = R;
                }
            }
        }
        return (int) dp[m - 1][n - 1][0];
    }
}