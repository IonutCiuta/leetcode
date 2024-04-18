class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int p = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    int n = 4;
                    if (valid(i - 1, j, rows, cols)) n -= grid[i - 1][j];
                    if (valid(i, j + 1, rows, cols)) n -= grid[i][j + 1];
                    if (valid(i + 1, j, rows, cols)) n -= grid[i + 1][j];
                    if (valid(i, j - 1, rows, cols)) n -= grid[i][j - 1];
                    p += n;
                }
            }
        }
        return p;
    }

    boolean valid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}