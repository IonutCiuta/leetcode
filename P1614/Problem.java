class Solution {
    public int maxDepth(String s) {
        var chars = s.toCharArray();
        var depth = 0;
        var maxDepth = 0;
        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
                continue;
            }
            if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}