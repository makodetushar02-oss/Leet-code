class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while (freqMap.get(nums[right]) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}