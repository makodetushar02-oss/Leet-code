class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i= 0;i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(IsValid(board , i, j , ch)){
                            board[i][j] = ch;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean IsValid(char[][] board ,int i,int j , char ch){
        for(int x= 0 ; x <9; x++){
            //  Row
            if(board[i][x] == ch ) return false;
            // column
            if(board[x][j] == ch ) return false;
            // Sub-Box
            if(board[3*(i/3)+x/3][3*(j/3)+x%3] == ch) return false;
        }
        return true;
    }
}