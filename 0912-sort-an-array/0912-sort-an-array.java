class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums , 0 , nums.length-1);
        return nums;
    }
    public static void MergeSort(int[] nums ,int s ,int e){
        if(s >= e) return;
        int mid = s+ (e-s)/2;
        MergeSort(nums , s , mid);
        MergeSort(nums , mid + 1 , e);
        conquer(nums , s , mid ,e );
    }
     public static void conquer(int[] nums ,int s ,int mid,int e){
       int[] merge = new int[e-s+1];
       int i = s, j = mid+1, k = 0;
       while(i <= mid  && j <= e){
        if(nums[i] <= nums[j]) merge[k++] = nums[i++];
        else merge[k++] = nums[j++];
       }
       while(i <= mid){
        merge[k++] = nums[i++];
       }
       while(j <= e){
        merge[k++] = nums[j++];
       }
       for(int t = 0; t< merge.length; t++){
        nums[t + s] = merge[t];
       }
     }
}