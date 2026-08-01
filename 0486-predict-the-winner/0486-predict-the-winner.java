class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return maxDiff(nums, 0, n - 1, memo) >= 0;
    }

    private int maxDiff(int[] nums, int left, int right, Integer[][] memo) {
        if (left == right) {
            return nums[left];
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int pickLeft = nums[left] - maxDiff(nums, left + 1, right, memo);
        int pickRight = nums[right] - maxDiff(nums, left, right - 1, memo);
        memo[left][right] = Math.max(pickLeft, pickRight);
        
        return memo[left][right];
    }
}