class Solution {
    public String greatestLetter(String s) {
        var c = s.toCharArray();
        var lower = new boolean[26];
        var upper = new boolean[26];

        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 97) {
                lower[c[i] - 'a'] = true;
            } else {
                upper[c[i] - 'A'] = true;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                char r = (char)('A' + i);
                return String.valueOf(r);
            }
        }

        return "";
    }
}