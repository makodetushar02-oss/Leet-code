class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        final int INF = 1_000_000;
        char[] c = s.toCharArray();

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                int best = INF;
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;
                    int m = len / d;          
                    int changes = 0;
                    for (int r = 0; r < d; r++) {
                        for (int t = 0; t < m / 2; t++) {
                            if (c[i + r + t * d] != c[i + r + (m - 1 - t) * d]) changes++;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) java.util.Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = 2 * j; i <= n; i++) {         
                for (int p = 2 * (j - 1); p <= i - 2; p++) {
                    if (dp[j - 1][p] >= INF) continue;
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][p] + cost[p][i - 1]);
                }
            }
        }
        return dp[k][n];
    }
}