class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int LIMIT = 2048;

        boolean[] present = new boolean[LIMIT];
        for (int num : nums) present[num] = true;
        int[] distinct = new int[Math.min(nums.length, LIMIT)];
        int distinctCount = 0;
        for (int i = 0; i < LIMIT; i++) {
            if (present[i]) distinct[distinctCount++] = i;
        }
        boolean[] round2 = new boolean[LIMIT];
        int round2Count = 0;
        outer2:
        for (int a = 0; a < distinctCount; a++) {
            for (int b = 0; b < distinctCount; b++) {
                int x = distinct[a] ^ distinct[b];
                if (!round2[x]) {
                    round2[x] = true;
                    round2Count++;
                    if (round2Count == LIMIT) break outer2;
                }
            }
        }
        boolean[] round3 = new boolean[LIMIT];
        int tripletCount = 0;
        outer3:
        for (int x = 0; x < LIMIT; x++) {
            if (!round2[x]) continue;
            for (int b = 0; b < distinctCount; b++) {
                int y = x ^ distinct[b];
                if (!round3[y]) {
                    round3[y] = true;
                    tripletCount++;
                    if (tripletCount == LIMIT) break outer3;
                }
            }
        }

        return tripletCount;
    }
}