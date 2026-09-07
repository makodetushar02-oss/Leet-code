class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int m = 0;
        while(m<=h){
            if(nums[m] == 2){
                int temp = nums[m];
                nums[m] = nums[h];
                nums[h] = temp;
                h--; 
            }else if(nums[m] == 0){
               int temp = nums[m];
                nums[m] = nums[l];
                nums[l] = temp;
                m++;
                l++; 
            }
            else{
                m++;
            }
        }
    }
}