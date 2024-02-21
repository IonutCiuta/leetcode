class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        var s1 = t1.toCharArray();
        var s2 = t2.toCharArray();
        if (s1.length == 0 || s2.length == 0) {
            return 0;
        }

        // Say we have s1 = "abcd" and s2 = "cdef"
        // We need an extra row and column as column because with the DP approach we:
        // try to compute the LCS between various substrings of s1 & s2, including the empty string =>
        // that's why the extra row & column filled with 0
        // e.g. 0) at dp[0, 3] we compute the LCS("", "cde") => always 0
        // e.g. 1) at dp[1, 1] we compute the LCS of s1[0] & s2[0] => LCS("a", "c") => 0
        final var dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // we need to decrement the counters due to the padding
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length][s2.length];
    }
}