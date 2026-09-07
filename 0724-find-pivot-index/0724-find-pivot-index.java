class Solution {
    public int pivotIndex(int[] nums) {
        int[] temp = new int[nums.length];
        int sum = 0;
        int rum = 0;
       for(int i = nums.length -1; i >= 0; i--){
            sum += nums[i];
            temp[i] = sum;  
       } 
       for(int i = 0; i< nums.length; i++){
            rum += nums[i];
        if(temp[i] == rum) return i;
       }
       return -1;
    }
}