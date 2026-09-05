class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0 ;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) count++;
        }
        int i = arr.length - 1;
        int j = arr.length - 1 + count;
        while(i != j){
            if(j < arr.length) arr[j] = arr[i];
            j--;
            if(arr[i] == 0){
                if(j < arr.length){
                arr[j] = arr[i];
                }
                j--;
            }
            i--;
        }
    }
}