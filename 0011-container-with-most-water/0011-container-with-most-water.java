class Solution {
    public int maxArea(int[] height) {
       int maxArea = 0;
       int i = 0 ;
       int n = height.length;
       int j = n-1; 
       while(i<j){
        int width = j-i;
        int length = Math.min(height[i], height[j]);
        int Area = length * width;
        maxArea = Math.max(Area , maxArea);
        if(height[i] < height[j]) i++;
        else j--;
       }
       return maxArea;
    }
}