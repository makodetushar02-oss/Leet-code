class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list , "", 0,0, n);
        return list;
    }
    private void backtrack(List<String> list, String currentString, int open , int close, int max){
        if(currentString.length() == max*2){
            list.add(currentString);
            return;
        }
        if(open < max){
            backtrack(list, currentString +"(", open+1,close, max);
        }
        if(close < open){
            backtrack(list,currentString +")", open,close+1,max);
        }
    }
}