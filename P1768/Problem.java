class Solution {
    public String mergeAlternately(String s1, String s2) {
        var sb = new StringBuilder("");
        int i = 0;
        int j = 0;
        int s1Len = s1.length();
        int s2Len = s2.length();

        while (i < s1Len && j < s2Len) {
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(j));
            i += 1;
            j += 1;
        }

        if (s1Len - i > 0) {
            sb.append(s1.substring(i));
        }

        if (s2Len - j > 0) {
            sb.append(s2.substring(j));
        }

        return sb.toString();
    }
}