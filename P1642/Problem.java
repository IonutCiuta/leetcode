class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        var occ = new HashMap<Character, List<Integer>>();

        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];
            var idx = occ.get(c);
            if (idx != null) {
                idx.add(i);
            } else {
                idx = new ArrayList<Integer>();
                idx.add(i);
                occ.put(c, idx);
            }
        }

        int max = -1;
        for (var e : occ.entrySet()) {
            var idx = e.getValue();

            if (idx.size() < 2) {
                continue;
            }

            var diff = idx.get(idx.size() - 1) - idx.get(0) - 1;
            max = Math.max(max, diff);
        }

        return max;
    }
}