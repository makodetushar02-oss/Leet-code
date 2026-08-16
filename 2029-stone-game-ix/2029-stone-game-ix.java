class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c0 = 0, c1 = 0, c2 = 0;

        for (int stone : stones) {
            int r = stone % 3;

            if (r == 0) {
                c0++;
            } else if (r == 1) {
                c1++;
            } else {
                c2++;
            }
        }
        if (c0 % 2 == 0) {
            return c1 > 0 && c2 > 0;
        }
        return  Math.abs(c1 - c2) > 2;
    }
}