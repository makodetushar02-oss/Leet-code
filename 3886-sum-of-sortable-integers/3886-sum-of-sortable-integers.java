class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                if (check(nums, n, k)) total += k;
                int k2 = n / k;
                if (k2 != k && check(nums, n, k2)) total += k2;
            }
        }
        return total;
    }

    private boolean check(int[] nums, int n, int k) {
        int prevMax = Integer.MIN_VALUE;
        for (int s = 0; s < n; s += k) {
            int descents = 0;
            int min = nums[s], max = nums[s];
            for (int j = 0; j < k; j++) {
                int cur = nums[s + j];
                int next = nums[s + (j + 1) % k];
                if (cur > next) {
                    descents++;
                    if (descents > 1) return false;
                    max = cur;  
                    min = next; 
                }
            }
            if (min < prevMax) return false; 
            prevMax = max;
        }
        return true;
    }
}