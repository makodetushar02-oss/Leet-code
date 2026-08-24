class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        n = len(stones)
        preSum = [0] * n
        preSum[0] = stones[0]
        for i in range(1, n):
            preSum[i] = preSum[i - 1] + stones[i]

        dp = preSum[n - 1]
        for i in range(n - 2, 0, -1):
            dp = max(dp, preSum[i] - dp)

        return dp     