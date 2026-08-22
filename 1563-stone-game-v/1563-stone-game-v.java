import java.util.Arrays;

class Solution {
    int[][] memo;
    int[] prefix;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
            Arrays.fill(memo[i], -1);
        }

        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stoneValue, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int maxScore = 0;
        for (int i = left; i < right; i++) {
            int leftSum = prefix[i + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[i + 1];

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, left, i));
            } else if (rightSum < leftSum) {
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, i + 1, right));
            } else {
                maxScore = Math.max(maxScore, leftSum + Math.max(
                    solve(stoneValue, left, i), 
                    solve(stoneValue, i + 1, right)
                ));
            }
        }
        return memo[left][right] = maxScore;
    }
}