class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
       for(char ch : s.toCharArray()){
        if(!st.isEmpty() && ch == '#'){
            st.pop();
        }else if(ch != '#'){
        st.push(ch);
        }
       } 
        while(!st.isEmpty()){
        sb1.append(st.pop());
        }
       st.clear();
        for(char ch : t.toCharArray()){
        if(!st.isEmpty() && ch == '#'){
            st.pop();
        }else  if(ch != '#'){
        st.push(ch);
        }
       }
       while(!st.isEmpty()){
        sb2.append(st.pop());
       }
       return (sb2.toString()).equals(sb1.toString());
    }
}