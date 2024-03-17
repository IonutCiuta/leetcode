class Solution {
    public int getLucky(String s, int k) {
        var azsum = new int[26];
        for (int i = 1; i < 27; i++) {
            azsum[i - 1] = (i / 10) + (i % 10);
        }

        var chars = s.toCharArray();
        var sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int pos = (int)(chars[i] - 'a');
            sum += azsum[pos];
        }

        k--;
        while (k > 0) {
            var digits = String.valueOf(sum).toCharArray();
            sum = 0;
            for (int i = 0; i < digits.length; i++) {
                sum += (digits[i] - '0');
            }
            k--;
        }
        return sum;
    }
}