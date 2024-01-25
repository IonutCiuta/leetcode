class Solution {
    public String removeStars(String s) {
        var sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            var c = s.charAt(i);
            if ('*' == c) {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
            i++;
        }

        return sb.toString();
    }
}