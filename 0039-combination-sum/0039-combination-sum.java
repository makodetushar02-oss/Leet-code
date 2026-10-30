class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans,curr,candidates,target,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans,List<Integer> curr,int[] candidates, int target,int i){
        if(target<0){
            return;
        }else if(target == 0){
            ans.add(new ArrayList<>(curr));
        }
        for(int j = i; j<candidates.length;j++){
            curr.add(candidates[j]);
            solve(ans,curr,candidates,target-candidates[j],j);
            curr.remove(curr.size() - 1);
        }
    }
}