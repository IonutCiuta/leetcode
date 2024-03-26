class Solution {
    public void setZeroes(int[][] matrix) {
        var rowsToZero = new HashSet<Integer>();
        var colsToZero = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero.add(i);
                    colsToZero.add(j);
                }
            }
        }

        for (var col : colsToZero) {
            for (var row = 0; row < matrix.length; row++) {
                if (rowsToZero.contains(row)) {
                    Arrays.fill(matrix[row], 0);
                }
                matrix[row][col] = 0;
            }
        }
    }
}