class Solution {
    public String longestPalindrome(String s) {
        var r = new Result();

        for (int i = 0; i < s.length(); i++) {
            isPalindrome(i, true, s, r);
            isPalindrome(i, false, s, r);
        }

        return r.sub;
    }

    void isPalindrome(int m, boolean isOdd, String s, Result r) {
        var left = m;
        var right = isOdd ? m : m + 1;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            var len = right - left + 1;
            if (len > r.len) {
                r.len = len;
                r.sub = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }

    class Result {
        int len = 0;
        String sub = "";
    }
}