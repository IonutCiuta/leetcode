class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (intv1, intv2) -> intv1[0] - intv2[0]);
        int len = intervals.length;
        int totalIntvs = len;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            j = i + 1;
            while (j < len) {
                var _1stIntv = intervals[i];
                var _2ndIntv = intervals[j];
                if (_1stIntv[1] < _2ndIntv[0]) {
                    i = j++;
                } else {
                    _1stIntv[1] = Math.max(_1stIntv[1], _2ndIntv[1]);
                    intervals[j++] = null;
                    totalIntvs--;
                }
            }
        }

        var r = new int[totalIntvs][2];
        int k = 0;
        for (int l = 0; l < len; l++) {
            if (intervals[l] != null) {
                r[k++] = intervals[l];
            }
        }

        return r;
    }
}