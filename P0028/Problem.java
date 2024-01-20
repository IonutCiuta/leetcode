class Solution {
    public int strStr(String haystack, String needle) {
        var nChars = needle.toCharArray();
        var hChars = haystack.toCharArray();

        int pivot = 0;
        while (pivot < hChars.length) {
            int i = pivot;
            int j = 0;
            while (j < nChars.length && i < hChars.length && hChars[i] == nChars[j]) {
                i++;
                j++;
            }

            if (j == nChars.length) {
                return i - nChars.length;
            }

            pivot++;
        }

        return -1;
    }
}