class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        var occ = new HashMap<Integer, Integer>();
        for (int n : arr) {
            var count = occ.get(n);
            if (count == null) occ.put(n, 1);
            else occ.put(n, count + 1);
        }

        var set = new HashSet(occ.values());
        return occ.size() == set.size();
    }
}