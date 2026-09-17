class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        int minLenSoFar = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            if (currentSum == target) {
                int currentLen = right - left + 1;
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currentLen + dp[left - 1]);
                } 
                minLenSoFar = Math.min(minLenSoFar, currentLen);
            }
            dp[right] = minLenSoFar;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}