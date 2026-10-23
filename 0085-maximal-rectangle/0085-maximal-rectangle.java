class Solution {
    public int maximalRectangle(char[][] matrix) {
       int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxA = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxA = Math.max(largestRectangleArea(heights), maxA);
        }
        return maxA;
    }
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