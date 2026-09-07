class Solution {
    public void setZeroes(int[][] matrix) {
       boolean[] col = new boolean[matrix[0].length];
       boolean[] row = new boolean[matrix.length];
       for(int i = 0; i<matrix.length; i++){
        for(int j = 0; j<matrix[i].length; j++){
        if(matrix[i][j] == 0){
            col[j] = true ;
            row[i] = true ;
        }
       }
       }
       for(int i = 0; i<matrix.length; i++){
        for(int j = 0; j<matrix[i].length; j++){
        if(col[j] || row[i] ){
            matrix[i][j] = 0 ;
        }
        }
       }
    }
}