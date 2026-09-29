class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        Boolean[][][] memo = new Boolean[m][n][m + n];
        
        return dfs(grid, 0, 0, 0, memo);
    }
    
    private boolean dfs(char[][] grid, int r, int c, int bal, Boolean[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        bal += (grid[r][c] == '(') ? 1 : -1;
        
        if (bal < 0) {
            return false;
        }
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }
        
        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }
        
        boolean isValid = false;
        
        // Try moving right
        if (c + 1 < n) {
            isValid = dfs(grid, r, c + 1, bal, memo);
        }
        
        // Try moving down if moving right didn't find a valid path
        if (!isValid && r + 1 < m) {
            isValid = dfs(grid, r + 1, c, bal, memo);
        }
        
        // Save to memo and return
        return memo[r][c][bal] = isValid;
    }
}