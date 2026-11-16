class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a = (long) need1 * cost1 + (long) need2 * cost2;
        long b = (long) Math.max(need1, need2) * costBoth;
        int m = Math.min(need1, need2);
        long c = (long) m * costBoth
               + (long) (need1 - m) * Math.min(cost1, costBoth)
               + (long) (need2 - m) * Math.min(cost2, costBoth);
        return Math.min(a, Math.min(b, c));
    }
}