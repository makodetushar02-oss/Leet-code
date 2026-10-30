class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans , curr , nums,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans, List<Integer> curr,int[] nums ,int i){
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
            // Skipping duplicate element
            while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
            solve(ans , curr , nums , i+1);
    }
}