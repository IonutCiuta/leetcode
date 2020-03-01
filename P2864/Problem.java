class Solution {
    public String maximumOddBinaryNumber(String s) {
        var digits = s.toCharArray();
        var first = digits.length - 1;

        int i = first - 1;
        if (digits[first] != '1') {
            for (; i >= 0; i--) {
                if (digits[i] == '1') {
                    digits[first] = '1';
                    digits[i--] = '0';
                    break;
                }
            }
        }

        int j = 0;
        while (j < i) {
            if (digits[j] == '0' && digits[i] == '1') {
                digits[j++] = '1';
                digits[i--] = '0';
            } else {
                if (digits[j] == '1') j++;
                if (digits[i] == '0') i--;
            }
        }

        return new String(digits);
    }
}