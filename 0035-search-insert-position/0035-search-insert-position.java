class Solution {
    public int searchInsert(int[] nums, int target) {
        int m = 0 ;
        int n = nums.length -1;
        while( m <= n){
            int mid = m + ( n- m)/2 ;
            if(nums[mid] == target){
                return mid ;
            }else if (nums[mid] < target){
                m = mid +1 ;
            }else{
                n = mid- 1 ;
            }
        }
        return m ;
    }
}