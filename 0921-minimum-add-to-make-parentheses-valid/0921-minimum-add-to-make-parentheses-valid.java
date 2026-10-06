class Solution {
    public int minAddToMakeValid(String s) {
       Stack<Integer> stack = new Stack<>();
       int unmatched = 0;
       for(int i = 0; i<s.length(); i++){
        if(s.charAt(i) == '('){
            stack.push(i);
        }else{if(stack.isEmpty()){
            unmatched++;
        }else{
            stack.pop();
        }
            
        }
       } 
       return stack.size() + unmatched;
    }
}