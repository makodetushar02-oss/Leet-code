class Solution {
    public static void fun(int i,int j,int arr[]){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp ;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        fun(0 , nums.length-1 , nums);
        fun(k , nums.length-1 , nums);
        fun(0 , k-1 , nums);
    }
}