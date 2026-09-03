class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;
        for (int num : nums1) {
            if (num < min) {
                min = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }
        return (min % 2 != 0) || !hasOdd;
    }
}
