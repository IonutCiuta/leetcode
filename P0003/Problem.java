class Solution {
    public int lengthOfLongestSubstring(String s) {
        var chars = s.toCharArray();
        var seen = new HashMap<Character, Integer>();
        var max = 0;

        var len = chars.length;
        if (len < 2) {
            return len;
        }

        var i = 0;
        var j = 0;
        while (i < len && j < len) {
            var c = chars[j];
            var occ = seen.get(c);

            // seen first time or seen in some other substring
            if (occ == null || occ < i) {
                seen.put(c, j); // update seen with newest occurance
                max = Math.max(max, j - i + 1); // curr len is diff between indexes + 1
            } else {
                // check if new max
                max = Math.max(max, j - i); // curr len is diff between indexes which excludes current char
                seen.put(c, j);
                i = occ + 1;
            }
            j++;
        }

        return max;
    }
}