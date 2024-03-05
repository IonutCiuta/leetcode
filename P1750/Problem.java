class Solution {
    public int minimumLength(String s) {
        var chars = s.toCharArray();

        int len = chars.length;
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char iRef = chars[i];
            char jRef = chars[j];

            if (iRef != jRef) break;

            int lenPref = 0;
            while (chars[i] == iRef && i < j - 1) {
                lenPref++;
                i++;
            }

            int lenSuf = 0;
            while (chars[j] == jRef && j > i - 1) {
                lenSuf++;
                j--;
            }

            len -= (lenPref + lenSuf);
        }
        return len;
    }
}