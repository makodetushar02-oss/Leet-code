class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missingElements = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            numSet.add(num);
        }
        for (int i = min; i <= max; i++) {
            if (!numSet.contains(i)) {
                missingElements.add(i);
            }
        }
        
        return missingElements;
    }
}