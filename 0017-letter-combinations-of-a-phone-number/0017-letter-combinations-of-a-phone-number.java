class Solution {
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs", "tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String curr = "";
        solve(ans,curr,digits,0);
        return ans;
    }
    public void solve(List<String> ans,String curr,String digits,int i){
        if(i == digits.length()){
            ans.add(curr);
            return;
        }
        String val = map[digits.charAt(i) - '0'];
        for(char ch : val.toCharArray() ){
            solve(ans,curr + ch,digits,i+1);
        }
    }
}