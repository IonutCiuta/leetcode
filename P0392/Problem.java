class Solution {
    public boolean isSubsequence(String s, String t) {
        var sLen = s.length();
        var tLen = t.length();

        if (sLen == 0 && tLen >= 0) {
            return true;
        }

        if (sLen > 0 && tLen == 0) {
            return false;
        }

        var sChars = s.toCharArray();
        var tChars = t.toCharArray();
        int i = 0;
        int j = 0;

        while (i < sLen && j < tLen) {
            if (sChars[i] == tChars[j]) {
                if (i == sLen - 1) {
                    return true;
                } else {
                    i += 1;
                    j += 1;
                }
            } else {
                j += 1;
            }
        }

        return false;
    }
}