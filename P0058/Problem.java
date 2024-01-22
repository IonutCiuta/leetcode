class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        var _1stCharSet = false;
        var len = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (_1stCharSet) {
                    return len;
                }
            } else {
                if (!_1stCharSet) {
                    _1stCharSet = true;
                }
                len++;
            }
            i--;
        }
        return len;
    }
}