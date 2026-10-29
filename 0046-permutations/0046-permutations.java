class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans,nums,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans, int[] nums,int i){
        if(i == nums.length -1){
            List<Integer> temp = new ArrayList<>();
            for(int v = 0; v < nums.length; v++){
                temp.add(nums[v]);
            }
            ans.add(temp);
            return;
        }
        for(int j = i; j< nums.length; j++){
            swap(i,j,nums);
            solve(ans,nums,i+1);
            swap(i,j,nums);
        }
    }
    public void swap(int i, int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}