class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        var dp = new int[rows][cols];

        dp[0][0] = grid[0][0] == 1 ? 0 : 1;

        // fill in first row
        for (int i = 1; i < cols; i++) {
            if (grid[0][i] == 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            }
        }

        // fill in first column
        for (int i = 1; i < rows; i++) {
            if (grid[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}