class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        
        for (int i = 0; i < n; ++i) {
            Set<Integer> s = new HashSet<>(); 
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; ++j) {
                set.add(nums.get(j));
                int d = set.size();
                res += d * d;
            }
        }
        
        return res;
    }
}