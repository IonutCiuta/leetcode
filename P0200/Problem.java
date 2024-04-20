class Solution {
    public int numIslands(char[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        var r = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                var p = grid[i][j];
                if (p == '1') {
                    r++;
                    bfs(i, j, grid);
                }
            }
        }

        return r;
    }

    void bfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';

        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            bfs(i - 1, j, grid);

        if (i + 1 < grid.length && grid[i + 1][j] == '1')
            bfs(i + 1, j, grid);

        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            bfs(i, j - 1, grid);

        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
            bfs(i, j + 1, grid);
    }
}