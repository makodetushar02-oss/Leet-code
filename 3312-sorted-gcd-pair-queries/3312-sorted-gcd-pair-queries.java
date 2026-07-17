class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }
        long[] exactCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long multiplesCount = 0;
            for (int j = i; j <= maxVal; j += i) {
                multiplesCount += count[j];
            }
            long pairs = (multiplesCount * (multiplesCount - 1)) / 2;
            for (int j = 2 * i; j <= maxVal; j += i) {
                pairs -= exactCount[j];
            }
            exactCount[i] = pairs;
        }
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + exactCount[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i];
            int left = 1, right = maxVal;
            int ans = maxVal;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefixSum[mid] > target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = ans;
        }
        return result;
    }
}