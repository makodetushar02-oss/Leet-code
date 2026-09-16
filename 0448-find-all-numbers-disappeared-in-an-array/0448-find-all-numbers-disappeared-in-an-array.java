class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
     int n = arr.length;
        int i = 0;
        while (i<n){
            int currentIntex = arr[i]-1;
            if(arr[i]!=arr[currentIntex]){
                Swap(arr , i , currentIntex);
            }
            else i++ ;
        }
        List<Integer> list = new ArrayList<>();
        for( int j = 0 ; j < n; j++){
            if(arr[j] != j+1){
                list.add(j+1);
            }
        }
        return list;
    }

    private static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}