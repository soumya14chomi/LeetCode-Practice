class Solution:
    def maxCoins(self, nums: list[int]) -> int:
        # Pad the array with 1s on both ends
        points = [1] + nums + [1]
        n = len(points)
        # dp[i][j] stores the maximum coins from bursting balloons in the range (i, j)
        dp = [[0] * n for _ in range(n)]

        # Iterate over the length of the ranges (from 2 to n-1)
        for length in range(2, n):
            # Iterate over the left boundary 'i'
            for i in range(n - length):
                # Calculate the right boundary 'j'
                j = i + length
                # Iterate through all possible 'k' (the last balloon to burst in the range (i, j))
                for k in range(i + 1, j):
                    coins = points[i] * points[k] * points[j]
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + coins)
        
        # The result is the max coins for the entire original range (0, n-1) in points
        return dp[0][n - 1]


        