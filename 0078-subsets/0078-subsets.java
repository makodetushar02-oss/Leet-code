class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans , curr , nums,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans, List<Integer> curr,int[] nums ,int i){
        // adding subset to ans 
        // base case
            if(i == nums.length){
                List<Integer> temp = new ArrayList<>();
                for(int ele : curr){
                    temp.add(ele);
                }
                ans.add(temp);
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