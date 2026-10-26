import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long currentSum = 0;
                    queue.offer(new int[]{i, j});
                    currentSum += grid[i][j];
                    grid[i][j] = 0; 
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                currentSum += grid[nr][nc];
                                grid[nr][nc] = 0; 
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    if (currentSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}