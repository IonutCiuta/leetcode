class Solution {
    public String frequencySort(String s) {
        var freq = new HashMap<Character, Integer>();
        var chars = s.toCharArray();

        for (var c : chars) {
            var occ = freq.get(c);
            if (occ == null) {
                freq.put(c, 1);
            } else {
                freq.put(c, ++occ);
            }
        }

        var entries = new ArrayList<>(freq.entrySet());
        Collections.sort(entries, (e1, e2) -> e2.getValue() - e1.getValue());

        var sb = new StringBuilder();
        for (var e : entries) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }
}