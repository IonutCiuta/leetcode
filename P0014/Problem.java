class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = 200;
        for (var s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        var pref = new StringBuilder();

        int j = 0;
        boolean allMatch = true;
        while (j < minLen && allMatch) {
            char ref = strs[0].charAt(j);

            for (int i = 1; i < strs.length; i++) {
                if (ref != strs[i].charAt(j)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                pref.append(ref);
                j++;
            }
        }

        return pref.toString();
    }
}