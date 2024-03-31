class Solution {
    public boolean makeEqual(String[] words) {
        var charMap = new int[26];

        for (int i = 0; i < words.length; i++) {
            var chars = words[i].toCharArray();
            for (var c : chars) {
                charMap[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charMap[i] % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}