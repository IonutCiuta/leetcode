class Solution {
    private boolean isV(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        var chars = s.toCharArray();

        var maxV = 0;
        var i = 0;
        while(i < k) {
            if (isV(chars[i])) maxV += 1;
            i += 1;
        }

        var start = 1;
        var end = i;
        var currV = maxV;
        while (end < chars.length) {
            if (isV(chars[start - 1])) currV -= 1;

            if (isV(chars[end])) currV += 1;

            if (currV > maxV) maxV = currV;

            if (maxV == k) break;

            start += 1;
            end += 1;
        }

        return maxV;
    }
}