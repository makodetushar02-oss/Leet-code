class Solution {
    public void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }
    public int[] sortedSquares(int[]arr) {
        for(int i = arr.length -1 ; i >= 0 ; i--){
            if(Math.abs(arr[i]) > Math.abs(arr[i]))
            swap(arr, i, arr.length-1);
        }
        for(int i = 0; i < arr.length ; i++){
            arr[i] = Math.abs(arr[i] *arr[i]);
        }
        Arrays.sort(arr);
        return arr;
    }
}