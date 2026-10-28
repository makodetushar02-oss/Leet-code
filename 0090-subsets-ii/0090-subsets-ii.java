class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans , curr , nums,0);
        return new ArrayList<>(ans);
    }
    public void solve(Set<List<Integer>> ans, List<Integer> curr,int[] nums ,int i){
        // base case
            if(i == nums.length){
                ans.add(new ArrayList<>(curr));
                return;
            }
            // include
            curr.add(nums[i]);
            // backTrack
            solve(ans , curr , nums , i+1);
            // exclude
            curr.remove(curr.size()-1);
            solve(ans , curr , nums , i+1);
        
    }
}