class Solution {
    public String reverseOnlyLetters(String s) {
        var chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            var iSet = false;
            var iChar = chars[i];
            if (iChar >= 'A' && iChar <= 'Z' || iChar >= 'a' && iChar <= 'z') {
                iSet = true;
            } else {
                i++;
            }

            var jSet = false;
            var jChar = chars[j];
            if (jChar >= 'A' && jChar <= 'Z' || jChar >= 'a' && jChar <= 'z') {
                jSet = true;
            } else {
                j--;
            }

            if (iSet && jSet) {
                char aux = chars[i];
                chars[i] = chars[j];
                chars[j] = aux;
                i++;
                j--;
            }
        }

        return new String(chars);
    }
}