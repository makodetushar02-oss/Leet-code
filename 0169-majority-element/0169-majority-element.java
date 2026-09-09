class Solution {
    public int majorityElement(int[] nums) {
        int win = nums[0];
        int vote = 1 ;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] == win){
                vote++;
            }else{
                vote--;
                if(vote == 0){
                win = nums[i];
                vote = 1;
            }
            }
        }
        return win;
    }
}