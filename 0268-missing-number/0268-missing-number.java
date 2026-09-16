class Solution {
    public int missingNumber(int[] arr) {
    int n = arr.length;
        int i = 0;
        while (i<n){
            int currentIntex = arr[i];
            if(arr[i] < n && arr[i] != arr[currentIntex] ){
                Swap(arr , i , currentIntex);
            }
            else i++ ;
        }
        for(int j = 0; j<n ; j++){
            if(arr[j] != j) return j ;
        }
        return n;
    }

    private static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}