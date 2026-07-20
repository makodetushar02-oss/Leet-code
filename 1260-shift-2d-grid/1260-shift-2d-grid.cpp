class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        int totalElements = m*n;
        vector<vector<int>> result(m, vector<int>(n , 0));
        for(int i = 0; i< m; ++i){
            for(int j = 0; j< n; ++j){
            int index = i*n + j;
            int new_index = (index + k) % totalElements;
            int new_i = new_index / n;
            int new_j = new_index% n;
            result[new_i][new_j] = grid[i][j];
        }
        }
        return result;
    }
};