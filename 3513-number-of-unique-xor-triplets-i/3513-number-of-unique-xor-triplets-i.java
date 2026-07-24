class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int msb = 0;
        int temp = n;
        while (temp > 0) {
            msb++;
            temp >>= 1;
        }
        return 1 << msb;
    }
}