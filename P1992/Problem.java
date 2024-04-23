class Solution {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;

        var r = new ArrayList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1) {
                    var c = new int[4];
                    c[0] = i;
                    c[1] = j;
                    explore(i, j, c, land);
                    r.add(c);
                }
            }
        }

        return r.toArray(new int[0][]);
    }

    void explore(int i, int j, int[] coord, int[][] land) {
        var r = i;
        while (r < land.length && land[r][j] == 1) r++;

        var c = j;
        while (c < land[0].length && land[i][c] == 1) c++;

        coord[2] = r - 1;
        coord[3] = c - 1;

        for (int row = i; row < r; row++) {
            for (int col = j; col < c; col++) {
                land[row][col] = 0;
            }
        }
    }
}