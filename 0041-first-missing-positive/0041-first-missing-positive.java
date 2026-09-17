class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i<n){
            if(nums[i] <= 0 || nums[i] > n){
                i++;
                continue;
            }
            int currentIndex = nums[i]-1;
            if(nums[i]!=nums[currentIndex]){
                Swap(nums , i , currentIndex);
            }
            else i++ ;
        }
        for(int j = 0 ; j < n; j++){
                if(nums[j] != j+1){
                    return j+1;
                }
            }
        return n+1;
    }

    private static void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}