class Solution {
    public int uniquePaths(int m, int n) {
        return paths(m, n);
    }

    int paths(int m, int n) {
        var dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    int paths(int i, int j, int m, int n, Integer[][] cache) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        var down = paths(i + 1, j, m, n, cache);
        var right = paths(i, j + 1, m, n, cache);
        var r = down + right;

        cache[i][j] = r;

        return r;
    }
}