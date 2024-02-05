class Solution {
    public int firstUniqChar(String s) {
        var chars = s.toCharArray();

        if (chars.length == 1) {
            return 0;
        }

        var cache = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - 'a';
            cache[j]++;
        }

        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - 'a';
            if (cache[j] == 1) {
                return i;
            }
        }

        return -1;
    }
}