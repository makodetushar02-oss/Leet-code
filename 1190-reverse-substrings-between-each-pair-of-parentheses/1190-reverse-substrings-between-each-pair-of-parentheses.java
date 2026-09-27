class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i= 0 ; i <n ; i++){
            if(s.charAt(i)== '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                int j = stack.pop();
                arr[i] = j ;
                arr[j] = i ;
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        int direction = 1;
        while(i<n){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = arr[i];
                direction = -direction;
            }else {
                result.append(s.charAt(i));
            }
            i+=direction;
        }
        return result.toString();
    }
}