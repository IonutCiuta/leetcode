class Solution {
    public int equalPairs(int[][] grid) {
        var rowsHash = new HashMap<String, Integer>();

        for (var row : grid) {
            var key = Arrays.toString(row);
            var occ = rowsHash.get(key);
            if (occ == null) {
                rowsHash.put(key, 1);
            } else {
                rowsHash.put(key, occ + 1);
            }
        }

        int n = grid.length;
        int r = 0;

        for (int i = 0; i < n; i++) {
            var col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            var key = Arrays.toString(col);
            var occ = rowsHash.get(key);
            if (occ != null) {
                r += occ;
            }
        }

        return r;
    }
}