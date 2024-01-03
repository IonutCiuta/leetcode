class Solution {
    public String reverseWords(String s) {
        var w = s.trim().split("\\s+");
        var r = new StringBuilder();
        for (int i = w.length - 1; i >= 0; i--) {
            r.append(w[i]);
            if (i > 0) r.append(" ");
        }
        return r.toString();
    }
}