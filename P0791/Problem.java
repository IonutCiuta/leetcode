class Solution {
    public String customSortString(String order, String s) {
        var orderChars = order.toCharArray();
        var orderUniqueChars = new HashSet<Character>();

        for (int i = 0; i < orderChars.length; i++) {
            orderUniqueChars.add(orderChars[i]);
        }

        var sCharsOcc = new HashMap<Character, Integer>();
        var sChars = s.toCharArray();
        var suffix = new StringBuilder();

        for (var c : sChars) {
            if (!orderUniqueChars.contains(c)) {
                suffix.append(c);
            } else {
                var occ = sCharsOcc.get(c);
                if (occ == null) sCharsOcc.put(c, 1);
                else sCharsOcc.put(c, occ + 1);
            }
        }

        var ordered = new StringBuilder();
        for (int i = 0; i < orderChars.length; i++) {
            var c = orderChars[i];
            var occ = sCharsOcc.get(c);
            if (occ != null) {
                while (occ > 0) {
                    ordered.append(c);
                    occ--;
                }
            }
        }

        return ordered.append(suffix.toString()).toString();
    }
}