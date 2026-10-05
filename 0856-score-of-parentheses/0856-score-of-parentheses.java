class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char i : s.toCharArray()){
            if(i == '('){
                stack.push(0);
            }else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2*v,1));
            }
        }
        return stack.pop();
    }
}