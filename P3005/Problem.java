class Solution {
    public int maxFrequencyElements(int[] nums) {
        var freq = new int[100];
        int max = 1;
        for (var n : nums) {
            var f = freq[n - 1];
            if (f == 0) {
                freq[n - 1] = 1;
            } else {
                var ff = f + 1;
                max = Math.max(max, ff);
                freq[n - 1] = ff;
            }
        }

        var r = 0;
        for (var n : freq) {
            if (n == max) r += n;
        }
        return r;
    }
}