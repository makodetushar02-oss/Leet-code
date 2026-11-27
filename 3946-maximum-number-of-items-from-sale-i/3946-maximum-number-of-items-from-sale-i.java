class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        final int MAX_VAL = 1500;
        int[] freq = new int[MAX_VAL + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        int[] multCount = new int[MAX_VAL + 1];
        for (int f = 1; f <= MAX_VAL; f++) {
            for (int m = f; m <= MAX_VAL; m += f) {
                multCount[f] += freq[m];
            }
        }

        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int freeCopies = Math.max(0, multCount[factor] - 1);

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1 + freeCopies);
            }

            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }
        return dp[budget];
    }
}