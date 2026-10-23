class Solution {
    public int largestRectangleArea(int[] heights) {
      Stack<Integer> st = new Stack<>();
      int n = heights.length - 1;
      int[] r = new int[n+1];
      int[] l = new int[n+1]; 
      for(int i = n;i >= 0 ; i--){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
        }
        r[i] = st.isEmpty() ? n+1 : st.peek();
        st.push(i); 
      }  
      st.clear();
       for(int i = 0;i <= n ; i++){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
        }
        l[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i); 
      } 
      int maxArea = 0;
      for(int i = 0; i<= n; i++){
        int area = heights[i] * (r[i] - l[i] - 1);
        maxArea = Math.max(area , maxArea);
      }
      return maxArea;
    }
}