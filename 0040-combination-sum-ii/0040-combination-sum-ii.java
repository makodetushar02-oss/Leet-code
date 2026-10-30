class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            return;
        }
        for(int j = i; j<candidates.length;j++){
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            if (candidates[j] > target) {
                break;
            }
            curr.add(candidates[j]);
            solve(ans,curr,candidates,target-candidates[j],j+1);
            curr.remove(curr.size() - 1);
        }
    }
}