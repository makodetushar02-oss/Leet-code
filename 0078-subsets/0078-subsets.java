class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans , new ArrayList<>() , nums,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans, List<Integer> temp,int[] nums ,int i){
        // adding subset to ans 
        ans.add(new ArrayList<>(temp));
        while(i < nums.length){
            // include
            temp.add(nums[i]);
            // backTrack
            solve(ans , temp , nums , i+1);
            // exclude
            temp.remove(temp.size()-1);
            i++;
        }
    }
}