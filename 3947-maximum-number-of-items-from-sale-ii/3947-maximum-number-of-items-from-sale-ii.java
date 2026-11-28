class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int min = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            min = Math.min(min, item[1]);
        }

       
        int[] cnt = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= n; m += f) {
                cnt[f] += freq[m];
            }
            cnt[f]--; 
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget, ans = 0;
        for (int[] item : items) {
            int price = item[1];
            if (price >= 2L * min) break;

            long take = Math.min(cnt[item[0]], remaining / price);
            ans += 2 * take;
            remaining -= take * price;
        }

        return (int) (ans + remaining / min);
    }
}