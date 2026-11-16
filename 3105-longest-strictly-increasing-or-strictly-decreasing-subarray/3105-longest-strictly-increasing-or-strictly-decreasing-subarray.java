class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1, best = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            best = Math.max(best, Math.max(inc, dec));
        }
        return best;
    }
}