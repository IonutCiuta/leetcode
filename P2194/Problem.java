class Solution {
    public List<String> cellsInRange(String s) {
        var cols = s.split(":");
        var firstCell = cols[0];
        var secondCell = cols[1];

        var r = new ArrayList<String>();
        var colStart = firstCell.charAt(0) - 'A';
        var rowStart = firstCell.charAt(1) - '0';

        var colEnd = secondCell.charAt(0) - 'A';
        var rowEnd = secondCell.charAt(1) - '0';

        for (int col = colStart; col <= colEnd; col++) {
            var sym = (char) (col + 'A');
            for (int row = rowStart; row <= rowEnd; row++) {
                r.add(new StringBuilder().append(sym).append(row).toString());
            }
        }

        return r;
    }
}