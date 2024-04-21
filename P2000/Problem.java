class Solution {
    public String reversePrefix(String word, char ch) {
        var chars = word.toCharArray();
        var end = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                end = i;
                break;
            }
        }

        if (end == -1) {
            return word;
        }

        int i = 0;
        int j = end;
        while (i < j) {
            var aux = chars[i];
            chars[i] = chars[j];
            chars[j] = aux;
            i++;
            j--;
        }

        return new String(chars);
    }
}