class Solution {
    public int countSubstrings(String s) {
        var chars = s.toCharArray();
        var r = 0;

        for (int len = 0; len < s.length(); len++) {
            for (int start = 0; start < s.length() - len; start++) {
                var end = start + len;
                if (isPalindrome(chars, start, end)) {
                    r++;
                }
            }
        }

        return r;
    }

    boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}