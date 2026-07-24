class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] uniqueNums = new boolean[2048];
        for (int num : nums) {
            uniqueNums[num] = true;
        }
        boolean[] round1 = uniqueNums;
        boolean[] round2 = new boolean[2048];
        boolean[] round3 = new boolean[2048];
        for (int i = 0; i < 2048; i++) {
            if (round1[i]) {
                for (int j = 0; j < 2048; j++) {
                    if (uniqueNums[j]) {
                        round2[i ^ j] = true;
                    }
                }
            }
        }
        int uniqueTripletsCount = 0;
        for (int i = 0; i < 2048; i++) {
            if (round2[i]) {
                for (int j = 0; j < 2048; j++) {
                    if (uniqueNums[j]) {
                        if (!round3[i ^ j]) {
                            round3[i ^ j] = true;
                            uniqueTripletsCount++;
                        }
                    }
                }
            }
        }
        return uniqueTripletsCount;
    }
}