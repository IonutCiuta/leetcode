class Solution {
    public int countGoodSubstrings(String s) {
        var len = s.length();
        if (len < 3) {
            return 0;
        }

        var chars = s.toCharArray();
        int r = 0;

        for (int i = 0; i < len - 2; i++) {
            if (chars[i] != chars[i + 1]
                    && chars[i + 1] != chars[i + 2]
                    && chars[i] != chars[i + 2]) {
                r++;
            }
        }

        return r;
    }
}